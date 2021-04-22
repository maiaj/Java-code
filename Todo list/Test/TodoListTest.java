import model.Task;
import model.TaskFilter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoListTest {

    @Test
    public void addTask() {
        TodoList todoList = new TodoList();

        todoList.addTask(new Task(1, "clean", false));
        assertEquals(1, todoList.getNumberOfTasks(TaskFilter.ALL));
        assertEquals("clean", todoList.getTasks(TaskFilter.ALL).get(0).getName());
        todoList.addTask(new Task(2, "sleep", false));
        assertEquals(2, todoList.getNumberOfTasks(TaskFilter.ALL));
    }

    @Test
    public void removeTask() {
        TodoList todoList = new TodoList();

        todoList.addTask(new Task(1, "clean", false));
        assertEquals(1, todoList.getNumberOfTasks(TaskFilter.ALL));
        todoList.addTask(new Task(2, "sleep", false));
        assertEquals(2, todoList.getNumberOfTasks(TaskFilter.ALL));
        todoList.removeTask(1);
        assertEquals(1, todoList.getNumberOfTasks(TaskFilter.ALL));
    }

     @Test
    public void setTaskAsDone() {
         TodoList todoList = new TodoList();

         todoList.addTask(new Task(1, "clean", false));
         todoList.addTask(new Task(2, "sleep", false));
         todoList.addTask(new Task(3, "read", false));
         todoList.setTaskAsDone(1);
         assertEquals(1, todoList.getNumberOfTasks(TaskFilter.DONE));
         assertEquals(2, todoList.getNumberOfTasks(TaskFilter.NOT_DONE));
     }


}