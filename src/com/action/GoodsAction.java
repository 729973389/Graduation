package com.action;

import com.entity.Cate;
import com.entity.Goods;
import com.service.CateService;
import com.service.GoodsService;
import com.until.VeDate;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction{
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CateService cateService;
    //添加服务项目数据
    @RequestMapping("createGoods.action")
    public String createGoods(){
        List<Cate> cateList=cateService.getAllCate();
        this.getRequest().setAttribute("cateList",cateList);
        return "admin/addgoods";
    }

    //添加服务项目数据
    @RequestMapping("addGoods.action")
    public void addGoods(Goods goods , HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            goods.setAddtime(VeDate.getStringDateShort());
            goods.setHits("0");
            goods.setSellnum("0");
            this.goodsService.insertGoods(goods);
            PrintWriter out=resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"新增服务项目成功\");window.location.href='/JiaZheng/goods/queryGoodsByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //删除服务项目
    @RequestMapping("deleteGoods.action")
    public void deleteGoods(String id,HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            this.goodsService.deleteGoods(id);
            PrintWriter out=resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"删除服务项目成功\");window.location.href='/JiaZheng/goods/queryGoodsByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //更新数据
    @RequestMapping("updateGoods.action")
    public void updateGoods(Goods goods,HttpServletResponse resp){
        try {
            resp.setCharacterEncoding("utf-8");
            this.goodsService.updateGoods(goods);
            PrintWriter out=resp.getWriter();
            out.println("<script language=\"javascript\">alert(\"修改服务项目成功\");window.location.href='/JiaZheng/goods/queryGoodsByCond.action';</script>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //返回修改服务项目数据页面
    @RequestMapping("getGoodsById.action")
    public String getGoodsById(String id){
        Goods goods=goodsService.getGoodsById(id);
        this.getRequest().setAttribute("goods",goods);
        List<Cate> cateList=cateService.getAllCate();
        this.getRequest().setAttribute("cateList",cateList);
        return  "admin/editgoods";
    }
    //按条件查询服务项目（模糊查询）
    @RequestMapping("queryGoodsByCond.action")
    public String queryGoodsByCond(String cond,String name,String number){
        Goods goods=new Goods();
        if (null!=cond){
            if ("goodsname".equals(cond)){
                goods.setGoodsname(name);
            }
            if ("image".equals(cond)){
                goods.setImage(name);
            }
            if ("cateid".equals(cond)){
                goods.setCateid(name);
            }
            if ("addtime".equals(cond)){
                goods.setAddtime(name);
            }
            if ("hits".equals(cond)){
                goods.setHits(name);
            }
            if ("sellnum".equals(cond)){
                goods.setSellnum(name);
            }
            if ("contents".equals(cond)){
                goods.setContents(name);
            }
        }
        List<String> nameList=new ArrayList<String>();
        List valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);

        PageHelper.getPage(this.goodsService.getGoodsByLike(goods),"goods",nameList,valueList,7,number,this.getRequest(),"query");
        nameList=null;
        valueList=null;
        return "admin/querygoods";
    }


}
