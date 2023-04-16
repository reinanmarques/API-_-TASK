package com.tasks.mtasks.services;

import java.util.List;
import java.util.UUID;

import com.tasks.mtasks.dto.TaskDto;

public interface TaskService {
    public List<TaskDto> findAll();
    public TaskDto save(TaskDto taskDto);
    public TaskDto findById(UUID id);
    public TaskDto Update(UUID id, TaskDto taskDto);
    public TaskDto delete(UUID id);
}
