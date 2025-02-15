package org.example.transportschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.transportschedule.dto.BusDto;
import org.example.transportschedule.entity.Bus;
import org.example.transportschedule.mapper.BusMapper;
import org.example.transportschedule.repository.BusRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusService {
    private final BusMapper busMapper;
    private final BusRepository busRepository;

    public Bus saveBus(BusDto busDto) {
        Bus entity = busMapper.toEntity(busDto);
        return busRepository.save(entity);
    }
//
    public Bus findById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        busRepository.deleteById(id);
    }

    public Iterable<Bus> findAll() {
        return busRepository.findAll();
    }



}
