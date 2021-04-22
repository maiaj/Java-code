import model.Task;
import model.TaskFilter;

import java.util.Scanner;

public class Main {

    private static void printListOfTask(TodoList todoList, TaskFilter filter) {
        String tasksToPrint = "";
        for (Task task : todoList.getTasks(filter)) {
            tasksToPrint = tasksToPrint + task.getTaskID() + " " + task.getName() + ", ";
        }
        System.out.println("There are the following tasks in your todo list: " + tasksToPrint + " . What would you like to do with your tasks?");
    }
    public static void main(String[] args) {

        System.out.println("What would you like to do with your tasks (ADD, DELETE, COMPLETE, SHOW, NOTHING):");
        Scanner sc = new Scanner(System.in);

        TodoList todoList = new TodoList();

        int lastId = 0;

        String line = "";
        while (!line.equals("NOTHING")) {
            line = sc.nextLine();

            if (line.equals("ADD")) {
                System.out.println("What task would you like to add?");
                line = sc.nextLine();
                todoList.addTask(new Task(++lastId, line, false));
                System.out.println("Task " + lastId + " " + line + " was added to your todo list. What would you like to do with your tasks?");
            } else if (line.equals("DELETE")) {
                System.out.println("Which task would you like to delete?");
                line = sc.nextLine();
                todoList.removeTask(Integer.parseInt(line));
                System.out.println("Task " + line + " was deleted from your todo list. What would you like to do with your tasks?");
            } else if (line.equals("COMPLETE")) {
                System.out.println("Which task would you like to complete?");
                line = sc.nextLine();
                todoList.setTaskAsDone(Integer.parseInt(line));
                System.out.println("Task " + line + " was marked as done. What would you like to do with your tasks?");
            } else if (line.equals("SHOW")) {
                System.out.println("Which tasks would you like to see (ALL, DONE, NOT_DONE)?");
                line = sc.nextLine();
                if (line.equals("ALL")) {
                    printListOfTask(todoList, TaskFilter.ALL);
                } else if (line.equals("DONE")) {
                    printListOfTask(todoList, TaskFilter.DONE);
                } else if (line.equals("NOT_DONE")) {
                    printListOfTask(todoList, TaskFilter.NOT_DONE);
                }
            }
        }
    }
}