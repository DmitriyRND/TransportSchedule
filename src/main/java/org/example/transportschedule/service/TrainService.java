package org.example.transportschedule.service;

import lombok.RequiredArgsConstructor;
import org.example.transportschedule.dto.TrainDto;
import org.example.transportschedule.entity.Train;
import org.example.transportschedule.mapper.TrainMapper;
import org.example.transportschedule.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
    private final TrainMapper trainMapper;

    public TrainDto save(TrainDto trainDto) {
        Train train = trainMapper.toTrain(trainDto);
        trainRepository.save(train);
        return trainDto;
    }

    public List<TrainDto> findAll() {
        List<Train> trains = trainRepository.findAll();
        List<TrainDto> trainDtos = new ArrayList<>();
        for (Train train : trains) {
            trainDtos.add(trainMapper.toTrainDto(train));
        }
        return trainDtos;
    }
    public TrainDto findById(Long id) {
        Train train = trainRepository.findById(id).orElse(null);
        return trainMapper.toTrainDto(train);
    }
    public void delete(Long id) {
        trainRepository.deleteById(id);
    }
    public TrainDto update(Long id, TrainDto trainDto) {
        Train train = trainRepository.findById(id).orElse(null);
        train.setArrivalCity(trainDto.arrivalCity());
        train.setDepartureCity(trainDto.departureCity());
        train.setArrivalTime(trainDto.arrivalTime());
        train.setDepartureTime(trainDto.departureTime());
        trainRepository.save(train);
        return trainMapper.toTrainDto(train);
    }//
}
