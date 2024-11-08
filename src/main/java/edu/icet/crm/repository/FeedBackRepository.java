package edu.icet.crm.repository;

import edu.icet.crm.entity.FeedBackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBackEntity,Integer> {
}
