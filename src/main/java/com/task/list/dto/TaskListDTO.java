package com.task.list.dto;

import com.task.list.entity.TaskList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;

public class TaskListDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Priority is required")
    @Min(value = 1, message = "Priority must be greater than zero")
    private Integer priority;

    private boolean performed;

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
