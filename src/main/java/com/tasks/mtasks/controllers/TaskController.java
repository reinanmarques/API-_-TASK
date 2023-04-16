package com.tasks.mtasks.controllers;

import com.tasks.mtasks.dto.TaskDto;
import com.tasks.mtasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<Page<TaskDto>> fincAll(Pageable pageable) {
        Page<TaskDto> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto dto) {
        dto = service.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable UUID id) {
        TaskDto taskDto = service.findById(id);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable UUID id, @RequestBody TaskDto dto) {
        dto = service.Update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
