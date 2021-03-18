package com.action;

import com.entity.Admin;
import com.service.AdminService;
import com.until.VeDate;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAction extends BaseAction{
    @Autowired

    private AdminService adminService;
    //登录
    @RequestMapping("login.action")/*添加请求路径*/
    public String login(){
        String username=this.getRequest().getParameter("username");//获取用户名
        System.out.println("username");
        String password=this.getRequest().getParameter("password");//获取密码

        Admin adminEntity=new Admin();
        adminEntity.setUsername(username);
        //根据username的值查询数据
        List<Admin> adminList=adminService.getAdminByCond(adminEntity);

        if (adminList.size()==0){
            this.getRequest().setAttribute("message","用户名不存在");
            return "admin/index";
        }else{
            Admin admin =adminList.get(0);
            if (password.equals(admin.getPassword())){
                this.getSession().setAttribute("adminid",admin.getAdminid());
                this.getSession().setAttribute("adminname",admin.getUsername());
                this.getSession().setAttribute("realname",admin.getRealname());
                this.getSession().setAttribute("role",admin.getRole());
            }else {
                this.getSession().setAttribute("message","密码错误");
                return "admin/index";
            }
        }

         return "admin/main";
    }
    /*修改密码*/
    @RequestMapping("editpwd.action")/*添加请求路径*/
    public void editpwd(HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
            String adminid = (String) this.getSession().getAttribute("adminid");
            String password = this.getRequest().getParameter("password");
            String newpassword = this.getRequest().getParameter("newpassword");
            String repassword = this.getRequest().getParameter("repassword");
            Admin admin = this.adminService.getAdminById(adminid);
            if (password.equals(admin.getPassword())) {
                if (newpassword.equals(repassword)){
                    admin.setPassword(repassword);
                    this.adminService.updateAdmin(admin);
                    out.println("<script language=\"javascript\">alert(\"修改密码成功\");window.location.href='editpwdFrame.jsp';</script>");
                }else {
                    out.println("<script language=\"javascript\">alert(\"新密码不一致\");window.location.href='editpwdFrame.jsp';</script>");
                }

            } else {
                out.println("<script language=\"javascript\">alert(\"原密码输入错误\");window.location.href='editpwdFrame.jsp';</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "admin/editpwdFrame";
    }
    /*后台用户退出登录*/
    @RequestMapping("exit.action")/*添加请求路径*/
    public String exit(){
         this.getSession().removeAttribute("adminid");
        this.getSession().removeAttribute("adminname");
        this.getSession().removeAttribute("realname");
        this.getSession().removeAttribute("role");
        return "admin/index";
    }

    @RequestMapping("createAdmin.action")/*添加请求路径*/
    public String createAdmin(){
        return "admin/addadmin";/*返回到jsp路径*/
    }

    /*新增后台人员*/
    @RequestMapping("addAdmin.action")
    public String addAdmin(Admin admin){/*Admin类中的名称必须跟form表单中的名称一一对应*/
         admin.setAddtime(VeDate.getStringDateShort());
        this.adminService.insertAdmin(admin);
        return "redirect:/admin/createAdmin.action";
    }

    //查询后台人员信息
    @RequestMapping("queryAdminByCond.action")
    public String queryAdminByCond(String cond,String name,String number){
        Admin admin=new Admin();
        if(cond!=null){
            if("username".equals(cond)){
                admin.setUsername(name);
            }
            if("password".equals(cond)){
                admin.setPassword(name);
            }
            if("realname".equals(cond)){
                admin.setRealname(name);
            }
            if("contact".equals(cond)){
                admin.setContact(name);
            }
            if("role".equals(cond)){
                admin.setRole(name);
            }
            if("addtime".equals(cond)){
                admin.setAddtime(name);
            }
        }
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);

        PageHelper.getPage(adminService.getAdminByLike(admin),"admin",nameList, valueList,7,number,this.getRequest(),"query");
        return "admin/queryadmin";
    }
    //修改后台人员信息
    @RequestMapping("getAdminById.action")
    public  String getAdminById(String id){
        Admin admin =this.adminService.getAdminById(id);
        this.getRequest().setAttribute("admin",admin);
        return "admin/editadmin";
    }

    @RequestMapping("updateAdmin.action")
    public String updateAdmin(Admin admin){
        this.adminService.updateAdmin(admin);
        return "redirect:/admin/queryAdminByCond.action";
    }
    //根据主键id删除后台人员信息
    @RequestMapping("deleteAdmin.action")
    public void deleteAdmin(String id,HttpServletResponse resp){
        try {
              resp.setCharacterEncoding("utf-8");
              this.adminService.deleteAdmin(id);
              PrintWriter out= resp.getWriter();

              out.println("<script language=\"javascript\">alert(\"删除后台人员成功\");window.location.href='/JiaZheng/admin/queryAdminByCond.action';</script>");
        }catch (IOException e){
              e.printStackTrace();
        }
       /* this.adminService.deleteAdmin(id);
        return "redirect:/admin/queryAdminByCond.action";*/
    }


}
