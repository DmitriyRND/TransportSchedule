package org.example.transportschedule.repository;

import org.example.transportschedule.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {

}
