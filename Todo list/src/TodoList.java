import model.Task;
import model.TaskFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoList implements ITodoList {

    private Map<Integer, Task> tasks;

    public TodoList() { this.tasks = new HashMap<>(); }

    @Override
    public void addTask(Task task) {
        this.tasks.put(task.getTaskID(), task);
    }

    @Override
    public void removeTask(int taskID) {
        this.tasks.remove(taskID);
    }

    @Override
    public List<Task> getTasks(TaskFilter filter) {
        ArrayList<Task> tasksList = new ArrayList<>();
        if (filter == TaskFilter.ALL) {
            tasksList = new ArrayList<>(this.tasks.values());
        }
        else if (filter == TaskFilter.DONE) {
            for (Task task : this.tasks.values()) {
                if (task.isDone() == true) {
                    tasksList.add(task);
                }
            }
        }
        else if (filter == TaskFilter.NOT_DONE) {
            for (Task task : this.tasks.values()) {
                if (task.isDone() == false) {
                    tasksList.add(task);
                }
            }
        }
        return tasksList;
    }

    @Override
    public void setTaskAsDone(int taskID) {
        for (Task task : this.tasks.values()) {
            if (task.getTaskID() == taskID) {
                task.setDone(true);
            }
        }
    }

    @Override
    public int getNumberOfTasks(TaskFilter filter) {
        int numberOfTask = 0;
        if (filter == TaskFilter.ALL) {
            numberOfTask = this.tasks.size();
        }
        else if (filter == TaskFilter.DONE) {
            for (Task task : this.tasks.values()) {
                if (task.isDone() == true) {
                    numberOfTask++;
                }
            }
        }
        else if (filter == TaskFilter.NOT_DONE) {
            for (Task task : this.tasks.values()) {
                if (task.isDone() == false) {
                    numberOfTask ++;
                }
            }
        }
        return numberOfTask;

    }
}
