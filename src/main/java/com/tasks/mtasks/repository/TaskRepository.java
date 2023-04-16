package com.tasks.mtasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasks.mtasks.entitiy.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
