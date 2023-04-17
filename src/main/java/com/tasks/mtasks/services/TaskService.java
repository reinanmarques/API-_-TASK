package com.tasks.mtasks.services;

import com.tasks.mtasks.dto.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TaskService {
    public Page<TaskDto> findAll(Pageable pageable);
    public TaskDto save(TaskDto taskDto);
    public TaskDto findById(UUID id);
    public TaskDto update(UUID id, TaskDto taskDto);
    public void delete(UUID id);
}
