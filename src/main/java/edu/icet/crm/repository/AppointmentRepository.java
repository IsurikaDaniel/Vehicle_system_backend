package edu.icet.crm.repository;

import edu.icet.crm.entity.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Long> {
}
