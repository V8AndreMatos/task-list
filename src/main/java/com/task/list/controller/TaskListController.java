package com.task.list.controller;

import com.task.list.dto.TaskListDTO;
import com.task.list.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public List<TaskListDTO> findAll(){
        return taskListService.findAllTasks();
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskListDTO> findById(@PathVariable Long id){

        TaskListDTO taskListDTO = taskListService.findById(id);
        return ResponseEntity.ok(taskListDTO);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> insertTaskList(@RequestBody TaskListDTO taskListDTO) {
        taskListService.insertTaskList(taskListDTO);
        return ResponseEntity.ok().body("Task successfully added");
    }


    @PutMapping
    public ResponseEntity<TaskListDTO> updateTaskList(@PathVariable Long id , TaskListDTO taskListDTO){

        taskListDTO = taskListService.updateTaskList(id , taskListDTO);

        return ResponseEntity.ok().body(taskListDTO);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){

        taskListService.deleteById(id);
       return ResponseEntity.ok().body("Id " +id+ " successfully deleted");
    }

}
