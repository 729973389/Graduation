package com.action;

import com.dao.EmployDAO;
import com.entity.Admin;
import com.entity.Employ;
import com.service.EmployService;
import com.until.VeDate;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employ")
@SessionAttributes("pass")
public class EmployAction extends BaseAction{
    @Autowired
    private EmployService employService;

    //准备添加数据
    @RequestMapping("createEmploy.action")
    public String createEmploy(){
        return "admin/addemploy";
    }

    //添加数据
    @RequestMapping("addEmploy.action")
    public String addEmploy(Employ employ){
        employ.setCheckone("是");
        employService.insertEmploy(employ);
        return "redirect:/employ/queryEmployByCond.action";
    }
    //审核表通过
    @RequestMapping("passCheckEmploy.action")
    public String addCheckEmploy(String id, Model model){
        Employ employ=employService.getEmployById(id);
        employ.setCheckone("是");
        employService.updateEmploy(employ);
        model.addAttribute("pass","审核成功");
        return "redirect:/employ/checkEmployByCond.action";
    }



    //更新数据
    @RequestMapping("updateEmploy.action")
    public String updateEmploy(Employ employ){
        employService.updateEmploy(employ);
        return "redirect:/employ/queryEmployByCond.action";
    }
    //删除数据
    @RequestMapping("deleteEmploy.action")
    public String deleteEmploy(String id){
        employService.deleteEmploy(id);
        return "redirect:/employ/queryEmployByCond.action";
    }
    //删除员工审核
    @RequestMapping("deleteCheckEmploy.action")
    public String deleteCheckEmploy(String id,Model model){
        employService.deleteEmploy(id);
        model.addAttribute("pass","审核失败");
        return "redirect:/employ/checkEmployByCond.action";
    }


    //按主键查询
    @RequestMapping("getEmployById.action")
    public String getEmployById(String id){
        Employ employ=employService.getEmployById(id);
        getRequest().setAttribute("employ",employ);
        return "admin/editemploy";
    }
    //按主键查询审核
    @RequestMapping("getCheckEmployById.action")
    public String getCheckEmployById(String id){
        Employ employ=employService.getCheckEmployById(id);
        getRequest().setAttribute("employ",employ);
        return "admin/editemploy";
    }


    //列表模糊查询
    @RequestMapping("queryEmployByCond.action")
    public String queryEmployByCond(String cond,String name,String number){
        Employ employ=new Employ();
        if (null!=cond){
            if ("realname".equals(cond)){
                employ.setRealname(name);
            }
            if ("sex".equals(cond)){
                employ.setSex(name);
            }
            if ("birthday".equals(cond)){
                employ.setBirthday(name);
            }
            if ("idcard".equals(cond)){
                employ.setIdcard(name);
            }
            if ("minzu".equals(cond)){
                employ.setMinzu(name);
            }
            if ("workdate".equals(cond)){
                employ.setWorkdate(name);
            }
            if ("contact".equals(cond)){
                employ.setContact(name);
            }
            if ("memo".equals(cond)){
                employ.setMemo(name);
            }
        }
        employ.setCheckone("是");
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(employService.getEmployByLike(employ),"employ",nameList,valueList,10,number,getRequest(),"query");
        return "admin/queryemploy";
    }
    //列表模糊查询审核
    @RequestMapping("checkEmployByCond.action")
    public String checkEmployByCond(String cond,String name,String number){
        Employ employ=new Employ();
        if (null!=cond){
            if ("realname".equals(cond)){
                employ.setRealname(name);
            }
            if ("sex".equals(cond)){
                employ.setSex(name);
            }
            if ("birthday".equals(cond)){
                employ.setBirthday(name);
            }
            if ("idcard".equals(cond)){
                employ.setIdcard(name);
            }
            if ("minzu".equals(cond)){
                employ.setMinzu(name);
            }
            if ("workdate".equals(cond)){
                employ.setWorkdate(name);
            }
            if ("contact".equals(cond)){
                employ.setContact(name);
            }
            if ("memo".equals(cond)){
                employ.setMemo(name);
            }
        }
        employ.setCheckone("否");
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(employService.getEmployByLike(employ),"employ",nameList,valueList,10,number,getRequest(),"query");
        return "admin/checkemploy";
    }
    //登录
    @RequestMapping("login2.action")/*添加请求路径*/
    public String login(Model model){
        String username=this.getRequest().getParameter("username");//获取用户名
        System.out.println(username);
        String password=this.getRequest().getParameter("password");//获取密码
        model.addAttribute("pass","");
        Employ employEntity=new Employ();
        employEntity.setUsername(username);
        //根据username的值查询数据
        List<Employ> employList=employService.getEmployByCond(employEntity);

        if (employList.size()==0){
            this.getRequest().setAttribute("message","用户名不存在");
            return "employ/index2";
        }else{
            Employ employ =employList.get(0);
            if (password.equals(employ.getPassword())){
                this.getSession().setAttribute("employid",employ.getEmployid());
                System.out.println();
                this.getSession().setAttribute("adminname",employ.getUsername());
                this.getSession().setAttribute("realname",employ.getRealname());
                String role="家政人员";
                this.getSession().setAttribute("role",role);
            }else {
                this.getSession().setAttribute("message","密码错误");
                return "employ/index2";
            }
        }
        return "employ/main2";
    }
    /*修改密码*/
    @RequestMapping("editpwd2.action")/*添加请求路径*/

    public void editpwd(HttpServletResponse resp) {
        try {
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
            String employid = (String) this.getSession().getAttribute("employid");
            String password = this.getRequest().getParameter("password");
            String repassword = this.getRequest().getParameter("repassword");
            Employ employ = this.employService.getEmployById(employid);
            if (password.equals(employ.getPassword())) {
                employ.setPassword(repassword);
                this.employService.updateEmploy(employ);
                out.println("<script language=\"javascript\">alert(\"修改密码成功\");window.location.href='editpwdFrame2.jsp';</script>");
            } else {
                out.println("<script language=\"javascript\">alert(\"原密码输入错误\");window.location.href='editpwdFrame2.jsp';</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*后台用户退出登录*/
    @RequestMapping("exit2.action")/*添加请求路径*/
    public String exit(){
        this.getSession().removeAttribute("adminid");
        this.getSession().removeAttribute("adminname");
        this.getSession().removeAttribute("realname");
        this.getSession().removeAttribute("role");
        return "employ/index2";
//        return "redirect:/employ/index2.jsp";
    }
    //按主键查询
    @RequestMapping("getEmployById2.action")
    public String getEmployById2(){
        String employid = (String) this.getSession().getAttribute("employid");
        Employ employ=employService.getEmployById(employid);
        getRequest().setAttribute("employ",employ);
        return "employ/editemploy2";
    }
    //更新数据
    @RequestMapping("updateEmploy2.action")
    public String updateEmploy2(Employ employ){
        employService.updateEmploy(employ);
//        return "redirect:/employ/getEmployById2.action";
        return "employ/main2";
    }
    //列表模糊查询
    @RequestMapping("queryEmployByCond2.action")
    public String queryEmployByCond2(String cond,String name,String number){
        Employ employ=new Employ();
//        if (null!=cond){
//            if ("realname".equals(cond)){
//                employ.setRealname(name);
//            }
//            if ("sex".equals(cond)){
//                employ.setSex(name);
//            }
//            if ("birthday".equals(cond)){
//                employ.setBirthday(name);
//            }
//            if ("idcard".equals(cond)){
//                employ.setIdcard(name);
//            }
//            if ("minzu".equals(cond)){
//                employ.setMinzu(name);
//            }
//            if ("workdate".equals(cond)){
//                employ.setWorkdate(name);
//            }
//            if ("contact".equals(cond)){
//                employ.setContact(name);
//            }
//            if ("memo".equals(cond)){
//                employ.setMemo(name);
//            }
//        }
//        List<String> nameList=new ArrayList<String>();
//        List<String> valueList=new ArrayList<String>();
//        nameList.add(cond);
//        valueList.add(name);
//        PageHelper.getPage(employService.getEmployByLike(employ),"employ",nameList,valueList,10,number,getRequest(),"query");
          return "employ/main2";
    }
    //添加数据
    @RequestMapping("addEmploy2.action")
    public void addEmploy2(Employ employ,HttpServletResponse resp,Model model){
        try {
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out=resp.getWriter();
            model.addAttribute("pass","审核等待");
            employ.setCheckone("否");
            employService.insertEmploy(employ);
            out.println("<script language=\"javascript\">alert(\"注册成功，请等待审核\");window.location.href='/JiaZheng/employ/check.jsp';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
