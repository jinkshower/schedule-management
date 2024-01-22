package com.schedulemanagement.service;

import com.schedulemanagement.dto.ScheduleRequestDto;
import com.schedulemanagement.dto.ScheduleResponseDto;
import com.schedulemanagement.entity.Schedule;
import com.schedulemanagement.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
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

    public ScheduleResponseDto getSchedule(Long id) {
         Schedule schedule = findSchedule(id);
         return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        validatePassword(schedule.getPassword(), scheduleRequestDto.getPassword());

        schedule.update(scheduleRequestDto);
        return new ScheduleResponseDto(schedule);
    }

    public Long deleteSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        validatePassword(schedule.getPassword(), scheduleRequestDto.getPassword());

        scheduleRepository.delete(schedule);
        return id;
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택된 메모를 찾을 수 없습니다."));
    }

    private void validatePassword(String origin, String input) {
        if (!origin.equals(input)) {
            throw new IllegalArgumentException("패스워드가 다릅니다");
        }
    }
}
