package org.example.transportschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.transportschedule.dto.BusDto;
import org.example.transportschedule.entity.Bus;
import org.example.transportschedule.service.BusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    @GetMapping("/addbus")
    public ResponseEntity<Bus> addBus(@RequestBody BusDto busDto) {
      return  ResponseEntity.ok(busService.saveBus(busDto));
    }
}
