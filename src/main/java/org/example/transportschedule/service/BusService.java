package org.example.transportschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.transportschedule.dto.BusDto;
import org.example.transportschedule.entity.Bus;
import org.example.transportschedule.mapper.BusMapper;
import org.example.transportschedule.repository.BusRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusService {
    private final BusMapper busMapper;
    private final BusRepository busRepository;
    private final RedisService redisService;

    private final static String KEY_CACHE = "bus:";

    public BusDto saveBus(BusDto busDto) {
        Bus entity = busMapper.toEntity(busDto);
        busRepository.save(entity);
        return busMapper.toDto(entity);
    }

    //
    public BusDto findById(Long id) {
        BusDto data = redisService.getData(KEY_CACHE + id, BusDto.class);

        if (data != null) {
            return data;
        }

        Bus bus = busRepository.findById(id).orElse(null);
        redisService.saveData(KEY_CACHE + id,busMapper.toDto(bus),10L);
        return busMapper.toDto(bus);
    }

    public void deleteById(Long id) {
        busRepository.deleteById(id);
    }

    public List<BusDto> findAll() {

        List<BusDto> busesFromCache = redisService.getAllData(KEY_CACHE + "*", BusDto.class);

        if (!busesFromCache.isEmpty()) {
            return busesFromCache;
        }

        List<Bus> busList = busRepository.findAll();
        List<BusDto> busListDto = new ArrayList<>();
        for (Bus bus : busList) {

            busListDto.add(busMapper.toDto(bus));
            redisService.saveData(KEY_CACHE + bus.getId(), busMapper.toDto(bus),10L);
        }
        return busListDto;
    }

    public BusDto update(Long id,BusDto busDto){
        Bus bus = busRepository.findById(id).orElse(null);
        bus.setArrivalCity(busDto.arrivalCity());
        bus.setDepartureCity(busDto.departureCity());
        bus.setDepartureTime(busDto.departureTime());
        bus.setArrivalTime(busDto.arrivalTime());
        bus.setPrice(busDto.price());
        busRepository.save(bus);
        return busMapper.toDto(bus);





    }


}
