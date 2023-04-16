package com.tasks.mtasks.entitiy;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private Date date;
    private Boolean complete;

    public Task() {
    }

    public Task(String title, Date date, Boolean complete) {
        this.title = title;
        this.date = date;
        this.complete = complete;
    }
}
