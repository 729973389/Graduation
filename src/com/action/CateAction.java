package com.action;

import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/cate")
public class CateAction extends BaseAction{
    @Autowired
    @Resource
    private CateService cateService;

    //新增服务类型页面
    @RequestMapping("createCate.action")
    public String createCate(){
        return"admin/addcate";
    }

    //添加服务类型数据
    @RequestMapping("addCate.action")
    public void addCate(Cate cate, HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            this.cateService.insertCate(cate);
            PrintWriter out= resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"新增服务类型成功\");window.location.href='/JiaZheng/cate/queryCateByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
       /* this.cateService.insertCate();
        return "redirect:/cate/createCate.action";*/
    }

    //通过主键删除服务类型
    @RequestMapping("deleteCate.action")
    public void deleteCate(String id,HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            this.cateService.deleteCate(id);
            PrintWriter out= resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"删除服务类型成功\");window.location.href='/JiaZheng/cate/queryCateByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
//        this.cateService.deleteCate(id);
//        return "redirect:/cate/createCate.action";
    }
    //更新服务类型数据
    @RequestMapping("updateCate.action")
    public void updateCate(Cate cate,HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            this.cateService.updateCate(cate);
            PrintWriter out= resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"更新服务类型成功\");window.location.href='/JiaZheng/cate/queryCateByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //按条件查询服务类型列表
    @RequestMapping("queryCateByCond.action")
    public String queryCateByCond(String cond,String name,String number){
        Cate cate=new Cate();
        if (cond!=null){
            if ("catename".equals(cond)){
                cate.setCatename(name);
            }
            if ("memo".equals(cond)){
                cate.setMemo(name);
            }
        }
        List<String> nameList=new ArrayList<String>();
        List<String> valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.cateService.getCateByLike(cate),"cate",nameList,valueList,10,number,this.getRequest(),"query");
         return "admin/querycate";
    }
    //根据服务类型主键查询服务数据，并且返回给前台
    @RequestMapping("getCateById.action")
    public String getCateById(String id){
        Cate cate = cateService.getCateById(id);
        this.getRequest().setAttribute("cate",cate);
        return "admin/editcate";
    }
}
