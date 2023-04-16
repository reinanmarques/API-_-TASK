package com.tasks.mtasks.util;

import com.tasks.mtasks.dto.TaskDto;
import com.tasks.mtasks.entitiy.Task;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static TaskDto entityToDTO(Task entity) {
        return new TaskDto(entity);
    }

    public static Task DTOtoEntity(TaskDto dto) {
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setComplete(dto.isComplete());
        return entity;
    }


}
