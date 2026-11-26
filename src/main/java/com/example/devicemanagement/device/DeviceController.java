package com.example.devicemanagement.device;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Device> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> get(@PathVariable("id") long id) {
        return ResponseEntity.of(service.findById(id));
    }
}
