package com.service.impl;

import com.dao.TopicDAO;
import com.entity.Topic;
import com.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDAO topicDAO;

    @Override
    public int insertTopic(Topic topic) {
        return topicDAO.insertTopic(topic);
    }

    @Override
    public int updateTopic(Topic topic) {
        return topicDAO.updateTopic(topic);
    }

    @Override
    public int deleteTopic(String topicid) {
        return topicDAO.deleteTopic(topicid);
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicDAO.getAllTopic();
    }

    @Override
    public List<Topic> getTopicByCond(Topic topic) {
        return topicDAO.getTopicByCond(topic);
    }

    @Override
    public List<Topic> getTopicByLike(Topic topic) {
        return topicDAO.getTopicByLike(topic);
    }

    @Override
    public Topic getTopicById(String topicid) {
        return topicDAO.getTopicById(topicid);
    }

    @Override
    public List<Topic> getTopicBar(Topic topic) {
        return topicDAO.getTopicBar(topic);
    }
}
