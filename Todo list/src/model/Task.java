package model;

public class Task {
    private int taskID;
    private String name;
    private boolean isDone;

    public Task(int taskID, String name, boolean isDone) {
        this.taskID = taskID;
        this.name = name;
        this.isDone = isDone;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}


