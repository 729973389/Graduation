package com.action;

import com.entity.*;
import com.service.*;
import com.until.VeDate;
import org.aspectj.weaver.ast.Or;
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
@RequestMapping("/index")
public class IndexAction extends BaseAction{
    @Autowired
    private CateService cateService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private TopicService topicService;
    @Autowired
    @Resource
    private ArticleService articleService;
    //公共方法 提供公共数据的查询
    private void front(){
        this.getRequest().setAttribute("title","家政服务平台管理系统");
        List<Cate> cateList=cateService.getAllCate();
        this.getRequest().setAttribute("cateList",cateList);
        List<Goods> hotList=goodsService.getGoodsByHot();
        this.getRequest().setAttribute("hotList",hotList);
    }
    @RequestMapping("index.action")
    public String index(){

        List<Cate> cateList=cateService.getCateFront();
        List<Cate> frontList=new ArrayList<Cate>();
        for(Cate cate : cateList){
            List<Goods> goodsList =goodsService.getGoodsByCate(cate.getCateid());
            cate.setGoodsList(goodsList);
            frontList.add(cate);
        }
        this.getRequest().setAttribute("frontList",frontList);
        return "users/index";
    }
    //服务详情
    @RequestMapping("detail.action")
    public String detail(String id){
        front();
        Goods goods=goodsService.getGoodsById(id);
        goods.setHits(String.valueOf(Integer.parseInt(goods.getHits())+1));
        goodsService.updateGoods(goods);
        this.getRequest().setAttribute("goods",goods);
        return "users/detail";
    }

    //准备注册
    @RequestMapping("preReg.action")
    public String preReg(){
        this.front();
        return "users/register";
    }
    //用户注册
    @RequestMapping("register.action")
    public String register(Users users){
        this.front();
        Users u=new Users();
        u.setUsername(users.getUsername());
        List<Users> usersList=usersService.getUsersByCond(u);
        if (0==usersList.size()){
            users.setRegdate(VeDate.getStringDateShort());
            usersService.insertUsers(users);
        }else {
            this.getSession().setAttribute("message","用户已经存在");
            return "redirect:/index/preReg.action";
        }
        return "redirect:/index/preReg.action";
    }
    //用户登录
    @RequestMapping("preLogin.action")
    public String preLogin(){
        this.front();
        return "users/login";
    }

    //登录操作
    @RequestMapping("login.action")
    public  String login(){
        this.front();
        String username =this.getRequest().getParameter("username");
        String password =this.getRequest().getParameter("password");
        Users u=new Users();
        u.setUsername(username);
        List<Users> usersList=usersService.getUsersByCond(u);
        if (0==usersList.size()){
            getSession().setAttribute("message","用户名不存在");
            return "redirect:/index/preLogin.action";
        }else{
            Users users=usersList.get(0);
            if (password.equals(users.getPassword())){
                getSession().setAttribute("userid",users.getUsersid());
                getSession().setAttribute("username",users.getUsername());
                getSession().setAttribute("users",users);
                return "redirect:/index/index.action";
            }else {
                getSession().setAttribute("message","密码错误");
                return "redirect:/index/preLogin.action";
            }
        }
    }

    //退出登录
    @RequestMapping("exit.action")
    public String exit(){
        this.front();
        /*session一直存在的，只是session里面的数据是添加和释放的*/
        getSession().removeAttribute("userid");
        getSession().removeAttribute("username");
        getSession().removeAttribute("users");
        return "index";

    }
    //进入用户中心页面
    @RequestMapping("usercenter.action")
    public String usercenter(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        return "users/usercenter";
    }
    //返回用户信息详情页面
    @RequestMapping("userinfo.action")
    public String userinfo(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        return "users/userinfo";
    }

    //修改个人信息
    @RequestMapping("personal.action")
    public void personal(Users users, HttpServletResponse resp){

        try {
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out=resp.getWriter();
            this.front();
            if (this.getSession().getAttribute("userid")==null){
                out.println("<script language=\"javascript\">alert(\"用户未登录\");window.location.href='/JiaZheng/index/preLogin.action';</script>");
            }
            usersService.updateUsers(users);
            getSession().setAttribute("users",usersService.getUsersById(users.getUsersid()));
            out.println("<script language=\"javascript\">alert(\"更新用户信息成功\");window.location.href='/JiaZheng/index/userinfo.action';</script>");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //返回修改密码页面
    @RequestMapping("prePwd.action")
    public String prePwd(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        return "users/editpwd";
    }

    //修改密码
    @RequestMapping("editpwd.action")
    public void editpwd(HttpServletResponse resp){

        try {
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out=resp.getWriter();
            this.front();
            if (null==getSession().getAttribute("userid")){
                out.println("<script language=\"javascript\">alert(\"用户未登录\");window.location.href='/JiaZheng/index/preLogin.action';</script>");
            }
            String userid=(String)getSession().getAttribute("userid");
            String password=getRequest().getParameter("password");
            String newpassword=getRequest().getParameter("newpassword");
            String repassword=getRequest().getParameter("repassword");
            Users users=usersService.getUsersById(userid);
            if (password.equals(users.getPassword())){
                if (newpassword.equals(repassword)){
                    users.setPassword(repassword);
                    usersService.updateUsers(users);
                    out.println("<script language=\"javascript\">alert(\"密码更新成功\");window.location.href='/JiaZheng/index/prePwd.action';</script>");
                }else {
                    out.println("<script language=\"javascript\">alert(\"密码确认不一致\");window.location.href='/JiaZheng/index/prePwd.action';</script>");
                }

            }else {
                out.println("<script language=\"javascript\">alert(\"旧密码错误\");window.location.href='/JiaZheng/index/prePwd.action';</script>");
            }

        }catch (IOException e){
            e.printStackTrace();
        }

//        this.front();
//        if (null==getSession().getAttribute("userid")){
//            return "redirect:/index/preLogin.action";
//        }
//        String userid=(String)getSession().getAttribute("userid");
//        String password=getRequest().getParameter("password");
//        String repassword=getRequest().getParameter("repassword");
//        Users users=usersService.getUsersById(userid);
//        if (password.equals(users.getPassword())){
//            users.setPassword(repassword);
//            usersService.updateUsers(users);
//        }else {
//            getSession().setAttribute("message","旧密码错误");
//            return "redirect:/index/prePwd.action";
//        }
//        return "redirect:/index/prePwd.action";
    }

    //添加服务项目到购物车
    @RequestMapping("addcart.action")
    public String addCart(){
        this.front();
        if(null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        String userid=(String)this.getSession().getAttribute("userid");
        Cart cart=new Cart();
        cart.setUsersid(userid);
        cart.setGoodsid(getRequest().getParameter("goodsid"));
        cart.setPrice(getRequest().getParameter("price"));
        cart.setAddtime(VeDate.getStringDateShort());
        cartService.insertCart(cart);
        return "redirect:/index/cart.action";

    }
    //查看购物车
    @RequestMapping("cart.action")
    public String cart(){
         this.front();
         if (null==getSession().getAttribute("userid")){
             return "redirect:/index/preLogin.action";
         }
         String userid=(String)getSession().getAttribute("userid");
         Cart cart=new Cart();
         cart.setUsersid(userid);
         List<Cart> cartList=cartService.getCartByCond(cart);
         getRequest().setAttribute("cartList",cartList);
         return "users/cart";
    }

    //删除购物车中的服务项目
    @RequestMapping("deletecart.action")
    public String deletecart(String id){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        cartService.deleteCart(id);
        return "redirect:/index/cart.action";

    }
    //准备结算
    @RequestMapping("preCheckout.action")
    public String preCheckout(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        String userid=(String)getSession().getAttribute("userid");
        Cart cart=new Cart();
        cart.setUsersid(userid);
        List<Cart> cartList=cartService.getCartByCond(cart);
        if (0==cartList.size()){
            getRequest().setAttribute("message","请选择家政服务项目");
            return "redirect:/index/cart.action";
        }
        return "users/checkout";
    }
    //结算
    @RequestMapping("checkout.action")
    public String checkout(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        String userid=(String) getSession().getAttribute("userid");
        Cart cart1=new Cart();
        cart1.setUsersid(userid);
        List<Cart> cartList=cartService.getCartByCond(cart1);
        if (0==cartList.size()){
            getRequest().setAttribute("message","请选择商品");
            return "redirect:/index/cart.action";
        }else {
            String ordercode="PD" + VeDate.geteStringDatex();
            double total=0;
            for (Cart cart:cartList){
                Items details=new Items();
                details.setGoodsid(cart.getGoodsid());
                details.setOrdercode(ordercode);
                details.setPrice(cart.getPrice());
                itemsService.insertItems(details);

                Goods goods=goodsService.getGoodsById(cart.getGoodsid());
                goods.setSellnum(String.valueOf(Integer.parseInt(goods.getSellnum()+1)));
                goodsService.updateGoods(goods);

                total+=Double.parseDouble(cart.getPrice());
                cartService.deleteCart(cart.getCartid());

            }
            String workdate=getRequest().getParameter("workdate");
            String enddate=getRequest().getParameter("enddate");
            String worktime=getRequest().getParameter("worktime");
            String address=getRequest().getParameter("address");
            String contact=getRequest().getParameter("contact");
            long days=VeDate.getDays(enddate,workdate);

            Orders orders=new Orders();
            orders.setAddress(address);
            orders.setAddtime(VeDate.getStringDateShort());
            orders.setContact(contact);
            orders.setStatus("未付款");
            orders.setTotal(String.valueOf(total));
            orders.setUsersid(userid);
            orders.setEnddate(enddate);
            orders.setWorkdate(workdate);
            orders.setWorktime(worktime);
            orders.setOrdercode(ordercode);
            ordersService.insertOrders(orders);
        }

        return "redirect:/index/showOrders.action";
    }


    //查看订单
    @RequestMapping("showOrders.action")
    public String showOrders(String number){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        String userid=(String) getSession().getAttribute("userid");
        Orders orders=new Orders();
        orders.setUsersid(userid);

        List<Orders> ordersList=new ArrayList<Orders>();
        List<Orders> tempList=ordersService.getOrdersByCond(orders);


        int pageNumber = tempList.size();/*代表数据有多少条数*/
        int maxPage = pageNumber;
        if (maxPage % 10 == 0) {
            maxPage = maxPage / 10;
        } else {
            maxPage = maxPage / 10 + 1;
        }
        if (number == null) {
            number = "0";
        }
        int start = Integer.parseInt(number) * 10;
        int over = (Integer.parseInt(number) + 1) * 10;
        int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; i++) {
            Orders o = tempList.get(i);
            ordersList.add(o);
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;共为");
        buffer.append(maxPage);
        buffer.append("页&nbsp; 共有");
        buffer.append(pageNumber);
        buffer.append("条&nbsp; 当前为第");
        buffer.append((Integer.parseInt(number) + 1));
        buffer.append("页 &nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("首页");
        } else {
            buffer.append("<a href=\"index/showOrders.action?number=0\">首页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("上一页");
        } else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("下一页");
        } else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("尾页");
        } else {
            buffer.append("<a href=\"index/showOrders.action?number=" + (maxPage - 1) + "\">尾页</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", html);
        this.getRequest().setAttribute("ordersList", ordersList);


        return "users/orderlist";
    }
    //准备付款
    @RequestMapping("prePay.action")
    public String prePay(String id){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        this.getRequest().setAttribute("id",id);
        return "users/pay";
    }

    //付款
    @RequestMapping("pay.action")
    public String pay(String id){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        Orders orders=ordersService.getOrdersById(getRequest().getParameter("id"));
        orders.setStatus("已付款");
        ordersService.updateOrders(orders);
        return "redirect:/index/showOrders.action";
    }
    //订单明细
    @RequestMapping("orderdetail.action")
    public String orderdetail(String id){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }

        Items items=new Items();
        items.setOrdercode(id);
        List<Items> detailsList=itemsService.getItemsByCond(items);
        getRequest().setAttribute("detailsList",detailsList);
        return "users/orderdetail";

    }

    //评价页面
    @RequestMapping("preTopic.action")
    public String preTopic(String id){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        Orders orders=ordersService.getOrdersById(getRequest().getParameter("id"));
        Items items=new Items();
        items.setOrdercode(orders.getOrdercode());
        List<Items> itemsList=itemsService.getItemsByCond(items);
        getRequest().setAttribute("detailsList",itemsList);
        getRequest().setAttribute("orders",orders);
        return "users/addTopic";

    }

    //新增评价
    @RequestMapping("addTopic.action")
    public String addTopic(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        Orders orders=ordersService.getOrdersById(getRequest().getParameter("id"));
        orders.setStatus("已评价");
        ordersService.updateOrders(orders);

        Items items=new Items();
        items.setOrdercode(orders.getOrdercode());
        List<Items> itemsList=itemsService.getItemsByCond(items);
        String userid=(String)getSession().getAttribute("userid");
        for(int i=0;i<itemsList.size();i++){
            Items x=itemsList.get(i);
            Topic topic=new Topic();
            topic.setUsersid(userid);
            topic.setOrdersid(orders.getOrdersid());
            topic.setGoodsid(x.getGoodsid());
            topic.setNum(getRequest().getParameter("num_"+i));
            topic.setContents(getRequest().getParameter("contents_"+i));
            topic.setAddtime(VeDate.getStringDateShort());
            topic.setStatus("未回复");
            topicService.insertTopic(topic);
        }
        return "redirect:/index/showOrders.action";
    }

    //我的评价
    @RequestMapping("myTopic.action")
    public String  myTopic(){
        this.front();
        if (null==getSession().getAttribute("userid")){
            return "redirect:/index/preLogin.action";
        }
        String userid=(String)getSession().getAttribute("userid");
        Topic topic =new Topic();
        topic.setUsersid(userid);
        List<Topic> topicList=topicService.getTopicByCond(topic);
        getRequest().setAttribute("topicList",topicList);
        return "users/myTopic";
    }

    // 公告
    @RequestMapping("article.action")
    public String article(String number) {
        this.front();
        List<Article> articleList = new ArrayList<Article>();
        List<Article> tempList = this.articleService.getAllArticle();
        int pageNumber = tempList.size();
        int maxPage = pageNumber;
        if (maxPage % 10 == 0) {
            maxPage = maxPage / 10;
        } else {
            maxPage = maxPage / 10 + 1;
        }
        if (number == null) {
            number = "0";
        }
        int start = Integer.parseInt(number) * 10;
        int over = (Integer.parseInt(number) + 1) * 10;
        int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; i++) {
            Article x = tempList.get(i);
            articleList.add(x);
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;共为");
        buffer.append(maxPage);
        buffer.append("页&nbsp; 共有");
        buffer.append(pageNumber);
        buffer.append("条&nbsp; 当前为第");
        buffer.append((Integer.parseInt(number) + 1));
        buffer.append("页 &nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("首页");
        } else {
            buffer.append("<a href=\"index/article.action?number=0\">首页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("上一页");
        } else {
            buffer.append("<a href=\"index/article.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("下一页");
        } else {
            buffer.append("<a href=\"index/article.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("尾页");
        } else {
            buffer.append("<a href=\"index/article.action?number=" + (maxPage - 1) + "\">尾页</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", html);
        this.getRequest().setAttribute("articleList", articleList);
        return "users/article";
    }

    // 阅读公告
    @RequestMapping("read.action")
    public String read(String id) {
        this.front();
        Article article = this.articleService.getArticleById(id);
        article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
        this.articleService.updateArticle(article);
        this.getRequest().setAttribute("article", article);
        return "users/read";
    }

    // 全部产品
    @RequestMapping("all.action")
    public String all(String number) {
        int pageSize = 10;
        this.front();
        List<Goods> goodsList = new ArrayList<Goods>();
        List<Goods> tempList = this.goodsService.getAllGoods();
        int pageNumber = tempList.size();
        int maxPage = pageNumber;
        if (maxPage % pageSize == 0) {
            maxPage = maxPage / pageSize;
        } else {
            maxPage = maxPage / pageSize + 1;
        }
        if (number == null) {
            number = "0";
        }
        int start = Integer.parseInt(number) * pageSize;
        int over = (Integer.parseInt(number) + 1) * pageSize;
        int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; i++) {
            Goods x = tempList.get(i);
            goodsList.add(x);
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;共为");
        buffer.append(maxPage);
        buffer.append("页&nbsp; 共有");
        buffer.append(pageNumber);
        buffer.append("条&nbsp; 当前为第");
        buffer.append((Integer.parseInt(number) + 1));
        buffer.append("页 &nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("首页");
        } else {
            buffer.append("<a href=\"index/all.action?number=0\">首页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("上一页");
        } else {
            buffer.append("<a href=\"index/all.action?number=" + (Integer.parseInt(number) - 1) + "\">上一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("下一页");
        } else {
            buffer.append("<a href=\"index/all.action?number=" + (Integer.parseInt(number) + 1) + "\">下一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("尾页");
        } else {
            buffer.append("<a href=\"index/all.action?number=" + (maxPage - 1) + "\">尾页</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", html);
        this.getRequest().setAttribute("goodsList", goodsList);
        return "users/list";
    }
    // 按分类查询
    @RequestMapping("cate.action")
    public String cate(String id, String number) {
        this.front();
        Goods goods = new Goods();
        goods.setCateid(id);
        List<Goods> goodsList = new ArrayList<Goods>();
        List<Goods> tempList = this.goodsService.getGoodsByCond(goods);
        int pageNumber = tempList.size();
        int maxPage = pageNumber;
        if (maxPage % 10 == 0) {
            maxPage = maxPage / 10;
        } else {
            maxPage = maxPage / 10 + 1;
        }
        if (number == null) {
            number = "0";
        }
        int start = Integer.parseInt(number) * 10;
        int over = (Integer.parseInt(number) + 1) * 10;
        int count = pageNumber - over;
        if (count <= 0) {
            over = pageNumber;
        }
        for (int i = start; i < over; i++) {
            Goods x = tempList.get(i);
            goodsList.add(x);
        }
        String html = "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("&nbsp;&nbsp;共为");
        buffer.append(maxPage);
        buffer.append("页&nbsp; 共有");
        buffer.append(pageNumber);
        buffer.append("条&nbsp; 当前为第");
        buffer.append((Integer.parseInt(number) + 1));
        buffer.append("页 &nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("首页");
        } else {
            buffer.append("<a href=\"index/cate.action?number=0&id=\" + id+ \"\">首页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if ((Integer.parseInt(number) + 1) == 1) {
            buffer.append("上一页");
        } else {
            buffer.append("<a href=\"index/cate.action?number=" + (Integer.parseInt(number) - 1) + "&id=\" + id+ \"\">上一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("下一页");
        } else {
            buffer.append("<a href=\"index/cate.action?number=" + (Integer.parseInt(number) + 1) + "&id=\" + id+ \"\">下一页</a>");
        }
        buffer.append("&nbsp;&nbsp;");
        if (maxPage <= (Integer.parseInt(number) + 1)) {
            buffer.append("尾页");
        } else {
            buffer.append("<a href=\"index/cate.action?number=" + (maxPage - 1) + "&id=\" + id+ \"\">尾页</a>");
        }
        html = buffer.toString();
        this.getRequest().setAttribute("html", html);
        this.getRequest().setAttribute("goodsList", goodsList);
        return "users/list";
    }

}
