package kz.bitlab.techorda2025.thirdProject.db;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static List<Task> taskList = new ArrayList<>();
    private static Long id = 6L;

    static {
        taskList.add(new Task(1L, "Complete task5", "2025-02-18", false));
        taskList.add(new Task(2L, "Clean home", "2025-02-18", true));
        taskList.add(new Task(3L, "Buy a cake", "2025-02-15", true));
        taskList.add(new Task(4L, "Complete all home tasks", "2025-02-20", false));
        taskList.add(new Task(5L, "Create a new branch with ur changes", "2025-02-18", false));
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static Task getTaskById(Long id) {
        return taskList.stream().filter(task -> task.getId()==id).findAny().orElse(null);
    }

    public static void addTask(Task task) {
        task.setId(id);
        taskList.add(task);
        id++;
    }

    public static void saveTask(Task task) {
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getId() == task.getId()) {
                taskList.set(i, task);
            }
        }
    }

    public static void deleteTask(Long id) {
        taskList.remove(TaskManager.getTaskById(id));
    }
}
