package com.example.devicemanagement.device;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceMapper mapper;

    public DeviceService(DeviceMapper mapper) {
        this.mapper = mapper;
    }

    public List<Device> findAll() {
        return mapper.findAll();
    }

    public Optional<Device> findById(long id) {
        return mapper.findById(id);
    }
}
