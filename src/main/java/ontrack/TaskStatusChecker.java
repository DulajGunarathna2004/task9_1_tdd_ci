package ontrack;

import java.util.HashMap;
import java.util.Map;

public class TaskStatusChecker {

    private Map<String, Map<String, String>> studentTasks;

    public TaskStatusChecker() {
        studentTasks = new HashMap<String, Map<String, String>>();

        Map<String, String> tasks = new HashMap<String, String>();

        tasks.put("task9.1", "TDD and CI,Pending Review,Waiting for tutor feedback");
        tasks.put("task8.1", "Unit Testing,Completed,Good work");

        studentTasks.put("s225098078", tasks);
    }

    public String getTaskStatus(String studentId, String taskId) {
        if (!studentTasks.containsKey(studentId)) {
            return "Student not found";
        }

        Map<String, String> tasks = studentTasks.get(studentId);

        if (!tasks.containsKey(taskId)) {
            return "Task not found";
        }

        String[] taskData = tasks.get(taskId).split(",");

        return "Task: " + taskData[0] + "\n" +
               "Status: " + taskData[1] + "\n" +
               "Message: " + taskData[2];
    }
}