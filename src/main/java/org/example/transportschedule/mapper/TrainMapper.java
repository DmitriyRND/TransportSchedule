package org.example.transportschedule.mapper;

import org.example.transportschedule.dto.TrainDto;
import org.example.transportschedule.entity.Train;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TrainMapper {
    Train toTrain(TrainDto trainDto);

    TrainDto toTrainDto(Train train);
}
