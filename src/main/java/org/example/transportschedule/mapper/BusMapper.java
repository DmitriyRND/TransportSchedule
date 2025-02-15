package org.example.transportschedule.mapper;

import org.example.transportschedule.dto.BusDto;
import org.example.transportschedule.entity.Bus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface BusMapper {

    Bus toEntity(BusDto busDto);
}
