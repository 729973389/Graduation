package com.action;

import com.entity.Allot;
import com.entity.Employ;
import com.entity.Orders;
import com.service.AllotService;
import com.service.EmployService;
import com.service.OrdersService;
import com.until.VeDate;
import com.util.PageHelper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/allot")
public class AllotAction extends BaseAction{
    @Autowired
    private AllotService allotService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private EmployService employService;

    //准备添加分配数据
    @RequestMapping("createAllot.action")
    public String createAllot(){
        Orders orders=new Orders();
        orders.setStatus("已付款");

        List<Orders> ordersList=ordersService.getOrdersByCond(orders);
        getRequest().setAttribute("ordersList",ordersList);

        List<Employ> employList=employService.getAllEmploy();
        getRequest().setAttribute("employList",employList);

        return "admin/addallot";
    }
    //添加分配数据
    @RequestMapping("addAllot.action")
    public String addAllot(Allot allot){
        allot.setStatus("进行中");
        allot.setAddtime(VeDate.getStringDateShort());
        allotService.insertAllot(allot);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("进行中");
        ordersService.updateOrders(orders);
        return "redirect:/allot/createAllot.action";

    }

//    //
//    @RequestMapping("queryAllotByCond.action")
//    public String queryAllotByCond(String cond,String name,String number){
//        Allot allot=new Allot();
//        if (null!=cond){
//            if ("ordersid".equals(name)){
//                allot.setOrdersid(name);
//            }
//            if ("employid".equals(name)){
//                allot.setEmployid(name);
//            }
//            if ("addtime".equals(name)){
//                allot.setAddtime(name);
//            }
//            if ("status".equals(name)){
//                allot.setStatus(name);
//            }
//
//        }
//        List nameList =new ArrayList<String>();
//        List valueList=new ArrayList<String>();
//        nameList.add(cond);
//        valueList.add(name);
//        PageHelper.getPage(allotService.getAllotByLike(allot),"allot",nameList,valueList,10,number,getRequest(),"query");
//        return "admin/queryallot";
//    }

    // 按条件查询数据 (模糊查询)
    @RequestMapping("queryAllotByCond.action")
    public String queryAllotByCond(String cond, String name, String number) {
        Allot allot = new Allot();
        if (cond != null) {
            if ("ordersid".equals(cond)) {
                allot.setOrdersid(name);
            }
            if ("employid".equals(cond)) {
                allot.setEmployid(name);
            }
            if ("addtime".equals(cond)) {
                allot.setAddtime(name);
            }
            if ("status".equals(cond)) {
                allot.setStatus(name);
            }
        }

        List<String> nameList = new ArrayList<String>();
        List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.allotService.getAllotByLike(allot), "allot", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "admin/queryallot";
    }
    //删除分配
    @RequestMapping("deleteAllot.action")
    public String deleteAllot(String id){
        Allot allot=allotService.getAllotById(id);
        allotService.deleteAllot(id);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("已付款");
        ordersService.updateOrders(orders);
        return "redirect:/allot/queryAllotByCond.action";
    }

    //更新数据
    @RequestMapping("updateAllot.action")
    public String updateAllot(Allot allot){
        allotService.updateAllot(allot);
        return "redirect:/allot/queryAllotByCond.action";
    }


    //按主键查询
    @RequestMapping("getAllotById.action")
    public String getAllotById(String id){
        Allot allot=allotService.getAllotById(id);
        getRequest().setAttribute("allot",allot);
        List<Orders> ordersList=ordersService.getAllOrders();
        this.getRequest().setAttribute("ordersList",ordersList);
        List<Employ> employList=employService.getAllEmploy();
        this.getRequest().setAttribute("employList",employList);
        return "admin/editallot";
    }
   //完成
    @RequestMapping("over.action")
    public String over(String id){
        Allot allot=allotService.getAllotById(id);
        allot.setStatus("完成");
        allotService.updateAllot(allot);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("完成");
        ordersService.updateOrders(orders);
        ordersService.updateOrders(orders);
        return "redirect:/allot/queryAllotByCond.action";


    }
    //准备添加分配数据
    @RequestMapping("createAllot2.action")
    public String createAllot2(){
        Orders orders=new Orders();
        orders.setStatus("已付款");

        List<Orders> ordersList=ordersService.getOrdersByCond(orders);
        getRequest().setAttribute("ordersList",ordersList);

        List<Employ> employList=employService.getAllEmploy();
        getRequest().setAttribute("employList",employList);

        return "employ/addallot2";
    }

    //添加分配数据
    @RequestMapping("addAllot2.action")
    public String addAllot2(Allot allot){
        String employid = (String) this.getSession().getAttribute("employid");
        allot.setEmployid(employid);
        allot.setStatus("进行中");
        allot.setAddtime(VeDate.getStringDateShort());
        allotService.insertAllot(allot);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("进行中");
        ordersService.updateOrders(orders);
        return "redirect:/allot/createAllot2.action";

    }


    // 按条件查询数据 (模糊查询)
    @RequestMapping("queryAllotByCond2.action")
    public String queryAllotByCond2(String cond, String name, String number) {
        Allot allot = new Allot();
        String employid = (String) this.getSession().getAttribute("employid");
        allot.setEmployid(employid);
        if (cond != null) {
            if ("ordersid".equals(cond)) {
                allot.setOrdersid(name);
            }
            if ("employid".equals(cond)) {
                allot.setEmployid(name);
            }
            if ("addtime".equals(cond)) {
                allot.setAddtime(name);
            }
            if ("status".equals(cond)) {
                allot.setStatus(name);
            }
        }

        List<String> nameList = new ArrayList<String>();
        List<String> valueList = new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(this.allotService.getAllotByLike(allot), "allot", nameList, valueList, 10, number, this.getRequest(), "query");
        name = null;
        cond = null;
        return "employ/queryallot2";
    }
    //删除分配
    @RequestMapping("deleteAllot2.action")
    public String deleteAllot2(String id){
        Allot allot=allotService.getAllotById(id);
        allotService.deleteAllot(id);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("已付款");
        ordersService.updateOrders(orders);
        return "redirect:/allot/queryAllotByCond2.action";
    }

    //完成
    @RequestMapping("over2.action")
    public String over2(String id){
        Allot allot=allotService.getAllotById(id);
        allot.setStatus("完成");
        allotService.updateAllot(allot);

        Orders orders=ordersService.getOrdersById(allot.getOrdersid());
        orders.setStatus("完成");
        ordersService.updateOrders(orders);
        ordersService.updateOrders(orders);
        return "redirect:/allot/queryAllotByCond2.action";
    }
    //按主键查询
    @RequestMapping("getAllotById2.action")
    public String getAllotById2(String id){
        Allot allot=allotService.getAllotById(id);
        getRequest().setAttribute("allot",allot);
        List<Orders> ordersList=ordersService.getAllOrders();
        this.getRequest().setAttribute("ordersList",ordersList);
        List<Employ> employList=employService.getAllEmploy();
        this.getRequest().setAttribute("employList",employList);
        return "employ/editallot2";
    }
    //更新数据
    @RequestMapping("updateAllot2.action")
    public String updateAllot2(Allot allot){
        allotService.updateAllot(allot);
        return "redirect:/allot/queryAllotByCond2.action";
    }




}
