import model.Task;
import model.TaskFilter;

import java.util.List;

public interface ITodoList {

    //vložení úkolu - úkol se vloží do úkolníčku

    void addTask(Task task);

    //smazání úkolu - úplně smaže úkol

    void removeTask(int taskID);

    //vypíše úkoly - na vstupu bude příznak, jestli se mají počítat všechny úkoly, nebo jen ty splněné nebo jen nesplněné

    List<Task> getTasks(TaskFilter filter);

    //splnění úkolu - nastaví se příznak, že úkol je splněn
    void setTaskAsDone(int taskID);

    //počet úkolů - na vstupu bude příznak, jestli se mají počítat všechny úkoly, nebo jen ty splněné nebo jen nesplněné
    int getNumberOfTasks(TaskFilter filter);
}
