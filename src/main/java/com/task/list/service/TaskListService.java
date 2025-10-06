package com.task.list.service;

import com.task.list.dto.TaskListDTO;
import com.task.list.entity.TaskList;
import com.task.list.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    // Find all tasks
    public List<TaskListDTO> findAllTasks(){
            List<Task> tasks = taskListRepository.findAll();
            return tasks.stream().map(x -> new TaskListDTO()).toList();
    }

    //Find by Id
    public TaskListDTO findById(Long id){
        TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " +id+ " not found ");
        return new TaskListDTO(taskList);
    }




    public void deleteById(Long id){
        if (!taskListRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        taskRepository.deleteById(id);

    }
}
