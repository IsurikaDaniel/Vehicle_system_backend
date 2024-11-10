package edu.icet.crm.repository;

import edu.icet.crm.entity.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;


public interface AppointmentRepository extends CrudRepository<AppointmentEntity,Long> {
}
