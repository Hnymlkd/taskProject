package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping(value="/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }
}
