package edu.icet.crm.repository;

import edu.icet.crm.entity.CustomerAccEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccRepository extends CrudRepository<CustomerAccEntity,Integer> {
}
