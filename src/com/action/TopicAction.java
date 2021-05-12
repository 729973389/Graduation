package com.action;

import com.entity.Topic;
import com.service.TopicService;
import com.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("topic")
public class TopicAction extends BaseAction{
    @Autowired
    private TopicService topicService;

    //模糊查询回复
    @RequestMapping("queryTopicByCond.action")
    public String queryTopicByCond(String cond,String name,String number){
        Topic topic=new Topic();
        if (null!=cond){
            if ("usersid".equals(cond)){
                topic.setUsersid(name);
            }
            if ("ordersid".equals(cond)){
                topic.setOrdersid(name);
            }
            if ("goodsid".equals(cond)){
                topic.setGoodsid(name);
            }
            if ("num".equals(cond)){
                topic.setNum(name);
            }
            if ("contents".equals(cond)){
                topic.setContents(name);
            }
            if ("addtime".equals(cond)){
                topic.setAddtime(name);
            }
            if ("status".equals(cond)){
                topic.setStatus(name);
            }
            if ("reps".equals(cond)){
                topic.setReps(name);
            }
        }
        List nameList=new ArrayList<String>();
        List valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(topicService.getTopicByLike(topic),"topic",nameList,valueList,10,number,getRequest(),"query");
        return "admin/querytopic";
    }


    @RequestMapping("getTopicById.action")
    public String getTopicById(String id) {
        Topic topic = topicService.getTopicById(id);
        getRequest().setAttribute("topic", topic);

        return "admin/edittopic";
    }


    @RequestMapping("updateTopic.action")
    public String updateTopic(Topic topic){
        topicService.updateTopic(topic);
        return "redirect:/topic/queryTopicByCond.action";
    }
    @RequestMapping("deleteTopic.action")
    public String deleteTopic(String id){
        topicService.deleteTopic(id);
        return "redirect:/topic/queryTopicByCond.action";
    }


    //模糊查询回复
    @RequestMapping("queryTopicByCond2.action")
    public String queryTopicByCond2(String cond,String name,String number){
        Topic topic=new Topic();
        if (null!=cond){
            if ("usersid".equals(cond)){
                topic.setUsersid(name);
            }
            if ("ordersid".equals(cond)){
                topic.setOrdersid(name);
            }
            if ("goodsid".equals(cond)){
                topic.setGoodsid(name);
            }
            if ("num".equals(cond)){
                topic.setNum(name);
            }
            if ("contents".equals(cond)){
                topic.setContents(name);
            }
            if ("addtime".equals(cond)){
                topic.setAddtime(name);
            }
            if ("status".equals(cond)){
                topic.setStatus(name);
            }
            if ("reps".equals(cond)){
                topic.setReps(name);
            }
        }
        List nameList=new ArrayList<String>();
        List valueList=new ArrayList<String>();
        nameList.add(cond);
        valueList.add(name);
        PageHelper.getPage(topicService.getTopicByLike(topic),"topic",nameList,valueList,10,number,getRequest(),"query");
        return "employ/querytopic2";
    }






}
