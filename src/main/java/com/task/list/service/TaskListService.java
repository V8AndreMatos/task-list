package com.task.list.service;

import com.task.list.dto.TaskListDTO;
import com.task.list.entity.TaskList;
import com.task.list.exception.ResourceNotFoundException;
import com.task.list.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    // Find all tasks
    public List<TaskListDTO> findAllTasks(){
            List<TaskList> tasks = taskListRepository.findAll();
            return tasks.stream().map(x -> new TaskListDTO()).toList();
    }

    //Find by Id
    public TaskListDTO findById(Long id){
        System.out.println("Searching for task with ID : " + id);
        TaskList taskList = taskListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " +id+ " not found "));
        return new TaskListDTO(taskList);
    }

    // Save TaskList
    public TaskListDTO saveTaskList(TaskListDTO taskListDTO){

        // DTO -> Entity
        TaskList taskList = new TaskList();
        taskList.setName(taskListDTO.getName());
        taskList.setDescription(taskListDTO.getDescription());
        taskList.setPerformed(taskListDTO.isPerformed());
        taskList.setPriority(taskListDTO.getPriority());


        // Save on database
        TaskList taskListSaved = taskListRepository.save(taskList);

        // Entity -> DTO
        return new TaskListDTO(taskListSaved.getId() , taskListSaved.getName() ,
                taskListSaved.getDescription(), taskListSaved.isPerformed(),
                taskListSaved.getPriority());
    }

    // Insert new taskList
    // Service
    public TaskListDTO insertTaskList(TaskListDTO taskListDTO) {
        TaskList taskList = new TaskList();

        // Copy to DTO to entity
        taskList.setName(taskListDTO.getName());
        taskList.setDescription(taskListDTO.getDescription());
        taskList.setPerformed(taskListDTO.isPerformed());
        taskList.setPriority(taskListDTO.getPriority());

        taskList = taskListRepository.save(taskList);
        return new TaskListDTO(taskList);
    }


    //Update a tasklist

    public TaskListDTO updateTaskList(Long id, TaskListDTO taskListDTO) {
        TaskList taskList = taskListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));

        taskList.setName(taskListDTO.getName());
        taskList.setDescription(taskListDTO.getDescription());
        taskList.setPerformed(taskListDTO.isPerformed());
        taskList.setPriority(taskListDTO.getPriority());

        TaskList updated = taskListRepository.save(taskList);
        return new TaskListDTO(updated);
    }



    // Delete By Id
    public void deleteById(Long id){
        if (!taskListRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        taskListRepository.deleteById(id);

    }
}
