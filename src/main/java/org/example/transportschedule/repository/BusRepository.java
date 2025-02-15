package org.example.transportschedule.repository;

import org.example.transportschedule.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface BusRepository extends JpaRepository<Bus,Long> {
}
