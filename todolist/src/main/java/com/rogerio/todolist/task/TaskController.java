package com.rogerio.todolist.task;


import com.rogerio.todolist.user.User;
import com.rogerio.todolist.utiils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;


    @PostMapping("/")
    public ResponseEntity createTask (@RequestBody Task newTask,HttpServletRequest request){

        var idUser = request.getAttribute("userId");
        newTask.setUserId((UUID) idUser);

        var currentDate = LocalDateTime.now();

        //validação de hora e data
        if (currentDate.isAfter(newTask.getStartAt()) || currentDate.isAfter(newTask.getEndsAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("start/end date must be greater than today's current date");
        }if (newTask.getStartAt().isAfter(newTask.getEndsAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("start date must be before the end date");
        }

        repository.save(newTask);
        return  ResponseEntity.ok(newTask);
    }

    @GetMapping("/")
    public List<Task> list(HttpServletRequest request) {
        var idUser = request.getAttribute("userId");
        var tasks = this.repository.findByUserId((User) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Task taskModel, @PathVariable UUID id,
                                 HttpServletRequest request) {
        var task = this.repository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Task not found");
        }

        var idUser = request.getAttribute("userId");

        if (!task.getUserId().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User does not have permission to change this task");
        }

        Utils.copyNonNullProperties(taskModel, task);

        var taskUpdated = this.repository.save(task);
        return ResponseEntity.ok().body(taskUpdated);

    }



}
