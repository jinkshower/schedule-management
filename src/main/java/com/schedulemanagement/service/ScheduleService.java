package com.schedulemanagement.service;

import com.schedulemanagement.dto.ScheduleRequestDto;
import com.schedulemanagement.dto.ScheduleResponseDto;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(ScheduleResponseDto::new)
                .toList();
    }
}
