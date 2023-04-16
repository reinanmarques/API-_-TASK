package com.tasks.mtasks.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tasks.mtasks.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tasks.mtasks.dto.TaskDto;
import com.tasks.mtasks.entitiy.Task;
import com.tasks.mtasks.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<TaskDto> findAll(Pageable pageable) {
        Page<Task> page = repository.findAll(pageable);
        return  page.map(t -> new TaskDto(t));
    }

    public TaskDto save(TaskDto dto) {
        Task entity = new Task();
        entity.setTitle(dto.getTitle());
        entity.setDate(dto.getDate());
        entity.setComplete(dto.isComplete());

        entity = repository.save(entity);
        return new TaskDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskDto findById(UUID id) {
        Optional<Task> obj = repository.findById(id);
        Task entity = obj.orElseThrow(() -> new RuntimeException("Entity Not Found "));
        return new TaskDto(entity);
    }

    @Override
    public TaskDto Update(UUID id, TaskDto taskDto) {
        Task entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Entity Not Found "));
        entity = Mapper.DTOtoEntity(taskDto);
        repository.save(entity);
        return new TaskDto(entity);
    }

    @Override
    public void delete(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Entity not found");
        }
    }
}
