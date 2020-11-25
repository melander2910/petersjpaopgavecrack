package com.jpaopgave.peter.controller;

import com.jpaopgave.peter.model.Task;
import com.jpaopgave.peter.repository.TaskRepo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestfullController {

    @Autowired
    TaskRepo taskRepo;

    //FETCH ALL
    @GetMapping("/tasks")
    public ResponseEntity<String> getTasks() throws JSONException {

            List<Task> taskList = (List<Task>) taskRepo.findAll();
            List<JSONObject> objects = new ArrayList<>();

            for (Task task : taskList){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", task.getId());
                jsonObject.put("name", task.getName());
                objects.add(jsonObject);
            }
            return ResponseEntity.ok(objects.toString());
    }

    //Create Task
    @PostMapping("/createtask")
    public String createReservation(String data, HttpSession session) throws JSONException {
        JSONObject taskdata = new JSONObject(data);
        Task task = new Task();
        task.setName(taskdata.getString("name"));
        taskRepo.save(task);
        return null;

        
    }
}

