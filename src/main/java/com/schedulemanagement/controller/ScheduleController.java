package com.schedulemanagement.controller;

import com.schedulemanagement.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @PostMapping
    public String createSchedule() {
        return "post";
    }

    @GetMapping
    public String getSchedules() {
        return "default get";
    }

    @GetMapping("/{id}")
    public String getSchedule(@PathVariable Long id) {
        return id + "get";
    }

    @PutMapping("/{id}")
    public String updateSchedule(@PathVariable Long id) {
        return id + "put";
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        return id + "delete";
    }
}
