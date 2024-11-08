package edu.icet.crm.service.impl;

import edu.icet.crm.dto.FeedBack;
import edu.icet.crm.entity.CustomerAccEntity;
import edu.icet.crm.entity.FeedBackEntity;
import edu.icet.crm.repository.FeedBackRepository;
import edu.icet.crm.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<FeedBack> getAll() {
        List<FeedBack> feedBackArrayList= new ArrayList<>();
        repository.findAll().forEach(entity->{
            feedBackArrayList.add(mapper.map(entity, FeedBack.class));
        });
        return feedBackArrayList;
    }

    @Override
    public void addFeedBack(FeedBack feedBack) {
        repository.save(mapper.map(feedBack, FeedBackEntity.class));
    }

    @Override
    public void updateFeedBack(FeedBack feedBack) {
        repository.save(mapper.map(feedBack, FeedBackEntity.class));
    }

    @Override
    public void deleteFeedBackById(Integer id) {
        repository.deleteById(id);
    }
}
