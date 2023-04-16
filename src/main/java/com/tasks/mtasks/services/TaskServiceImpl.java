package com.tasks.mtasks.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tasks.mtasks.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tasks.mtasks.dto.TaskDto;
import com.tasks.mtasks.entitiy.Task;
import com.tasks.mtasks.repository.TaskRepository;

@Service
@Primary
public  class TaskServiceImpl implements TaskService {
    @Autowired
    private  TaskRepository repository;

    public List<TaskDto> findAll(){
         List<Task> list =  repository.findAll();
        return list.stream().map(t -> new TaskDto(t)).toList();
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
    public TaskDto findById(UUID id) {
       Optional<Task> obj =  repository.findById(id);
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
    public TaskDto delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
