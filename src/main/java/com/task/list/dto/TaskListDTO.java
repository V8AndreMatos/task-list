package com.task.list.dto;

import com.task.list.entity.TaskList;

public class TaskListDTO {

    private Long id;

    private String name;
    private String description;
    private boolean performed;
    private int priority;

    public TaskListDTO() {
    }

    public TaskListDTO(TaskList entity){
            id = entity.getId();
            name = entity.getName();
            description = entity.getDescription();
            performed = entity.isPerformed();
            priority = entity.getPriority();
    }

    public TaskListDTO(Long id, String name, String description, boolean performed, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.performed = performed;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerformed() {
        return performed;
    }

    public void setPerformed(boolean performed) {
        this.performed = performed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
