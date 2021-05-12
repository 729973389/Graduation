package com.service;

import com.entity.Topic;

import java.util.List;

public interface TopicService {
     //新增评价
    public int insertTopic(Topic topic);
    //更新评价
    public int updateTopic(Topic topic);
    //删除评价
    public int deleteTopic(String topicid);
    //查询所有评价
    public List<Topic> getAllTopic();
    //根据条件进行评价查看
    public List<Topic> getTopicByCond(Topic topic);

    //模糊查询
    public List<Topic> getTopicByLike(Topic topic);

    //根据主键进行查询
    public Topic getTopicById(String topicid);
    //
    public List<Topic> getTopicBar(Topic topic);













}
