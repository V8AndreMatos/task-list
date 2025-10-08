package com.task.list.controller;

import com.task.list.dto.TaskListDTO;
import com.task.list.service.TaskListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<TaskListDTO> findAllTasks() {
        return taskListService.findAllTasks();
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskListDTO> findById(@PathVariable Long id) {

        TaskListDTO taskListDTO = taskListService.findById(id);
        return ResponseEntity.ok(taskListDTO);
    }

    @PostMapping
    public ResponseEntity<TaskListDTO> insertTask(@Valid @RequestBody TaskListDTO dto) {
        TaskListDTO created = taskListService.insertTaskList(dto);
        URI uri = URI.create("/tasks/" + created.getId()); // location of the new resource
        return ResponseEntity.created(uri).body(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskListDTO> updateTaskList(@PathVariable Long id,
                                                      @RequestBody TaskListDTO taskListDTO) {

        taskListDTO = taskListService.updateTaskList(id, taskListDTO);

        return ResponseEntity.ok().body(taskListDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        taskListService.deleteById(id);
        return ResponseEntity.noContent().build(); // return 204 No Content
    }

}


