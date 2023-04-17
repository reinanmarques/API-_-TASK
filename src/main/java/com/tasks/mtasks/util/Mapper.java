package com.tasks.mtasks.util;

import com.tasks.mtasks.dto.TaskDto;
import com.tasks.mtasks.entitiy.Task;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static TaskDto toDTO(Task entity) {
        return new TaskDto(entity);
    }

    public static void toEntity(TaskDto dto, Task entity) {
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setComplete(dto.isComplete());
    }

    public static Task toEntity(TaskDto dto) {
        Task entity = new Task();
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setComplete(dto.isComplete());
        return entity;
    }
}
