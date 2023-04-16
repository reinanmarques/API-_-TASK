package com.tasks.mtasks.dto;

import com.tasks.mtasks.entitiy.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDto implements Serializable {
    private UUID id;
    private String title;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private boolean complete;

    public TaskDto(Task entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.date = entity.getDate();
        this.complete = entity.getComplete();
    }
}
