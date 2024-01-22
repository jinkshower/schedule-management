package com.schedulemanagement.controller;

import com.schedulemanagement.dto.ScheduleRequestDto;
import com.schedulemanagement.dto.ScheduleResponseDto;
import com.schedulemanagement.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
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
