package edu.icet.crm.service;


import edu.icet.crm.dto.FeedBack;

import java.util.List;

public interface FeedBackService {
    List<FeedBack> getAll();
    void addFeedBack(FeedBack feedBack);
    void updateFeedBack(FeedBack feedBack);
    void deleteFeedBackById(Integer id);
}
