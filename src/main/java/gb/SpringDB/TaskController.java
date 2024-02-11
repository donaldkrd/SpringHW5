package gb.SpringDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/filter/{status}")
    public List<Task> filterByStatus(@PathVariable Task.Status status) {
        return taskService.filterByStatus(status);
    }
    @GetMapping("/sort")
    public List<Task> sortById(){
        return taskService.sortById();
    }
    @PutMapping("/update/{id}")
    public Task updateTaskByStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskByStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
