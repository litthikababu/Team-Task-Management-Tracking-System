package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class TaskStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldStatus;
    private String newStatus;

    @ManyToOne
    private Task task;

    @ManyToOne
    private User changedByUser;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOldStatus() { return oldStatus; }
    public void setOldStatus(String oldStatus) { this.oldStatus = oldStatus; }

    public String getNewStatus() { return newStatus; }
    public void setNewStatus(String newStatus) { this.newStatus = newStatus; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    public User getChangedByUser() { return changedByUser; }
    public void setChangedByUser(User changedByUser) { this.changedByUser = changedByUser; }
}
