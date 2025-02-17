package org.example.transportschedule.controller;

import lombok.RequiredArgsConstructor;
import org.example.transportschedule.dto.BusDto;
import org.example.transportschedule.entity.Bus;
import org.example.transportschedule.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    @PostMapping
    public ResponseEntity<BusDto> addBus(@RequestBody BusDto bus) {
        return ResponseEntity.ok(busService.saveBus(bus));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable Long id) {
        BusDto bus = busService.findById(id);
        if (bus != null) {
            return ResponseEntity.ok(bus);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBuses() {
        List<BusDto> buses = busService.findAll();
        return ResponseEntity.ok(buses);
    }
}
