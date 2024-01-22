package com.schedulemanagement.dto;

import com.schedulemanagement.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
    }
}
