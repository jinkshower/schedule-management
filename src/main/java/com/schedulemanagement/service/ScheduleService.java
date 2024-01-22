package com.schedulemanagement.service;

import com.schedulemanagement.dto.ScheduleRequestDto;
import com.schedulemanagement.dto.ScheduleResponseDto;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    public ScheduleResponseDto getSchedule(Long id) {
         Schedule schedule = findSchedule(id);
         return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ResponseEntity<ScheduleResponseDto> updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        if (!schedule.getPassword().equals(scheduleRequestDto.getPassword())) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        schedule.update(scheduleRequestDto);
        return ResponseEntity.ok().body(new ScheduleResponseDto(schedule));
    }

    public ResponseEntity<Void> deleteSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        if (!schedule.getPassword().equals(scheduleRequestDto.getPassword())) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(403));
        }

        scheduleRepository.delete(schedule);
        return ResponseEntity.noContent().build();
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택된 메모를 찾을 수 없습니다."));
    }
}
