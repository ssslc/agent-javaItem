package com.example.devicemanagement.device;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeviceApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void listsSeededDevices() throws Exception {
        mvc.perform(get("/api/devices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].assetCode").value("DEV-001"));
    }

    @Test
    void returnsDeviceDetails() throws Exception {
        mvc.perform(get("/api/devices/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("办公笔记本"))
                .andExpect(jsonPath("$.status").value("IN_USE"));
    }

    @Test
    void returnsNotFoundWhenDeviceDoesNotExist() throws Exception {
        mvc.perform(get("/api/devices/{id}", 999))
                .andExpect(status().isNotFound());
    }
}
