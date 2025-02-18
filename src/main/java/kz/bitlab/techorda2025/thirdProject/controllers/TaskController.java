package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @GetMapping(value="/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }

    @GetMapping(value = "/details/{idishka}")
    public String getDetailOfTask(Model model,
                                  @PathVariable("idishka") Long id) {
        model.addAttribute("task", TaskManager.getTaskById(id));
        return "details";
    }

    @PostMapping(value="/saveTask")
    public String saveTask(@RequestParam(name="id") Long id,
                           @RequestParam(name="taskName") String taskName,
                           @RequestParam(name="description") String description,
                           @RequestParam(name="date") String date,
                           @RequestParam(name="complete") String complete){
        Task task = Task.builder()
                .id(id)
                .name(taskName)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        TaskManager.saveTask(task);
        return "redirect:/tasks";
    }

    @DeleteMapping(value="/deleteTask")
    public String deleteTask(@RequestParam(name="id") Long id) {
        TaskManager.deleteTask(id);
        return "redirect:/tasks";
    }
}
