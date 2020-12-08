package Model;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> list;

  public TaskList()
  {
    list=new ArrayList<>();
  }

  public void addTask(Task task){
    list.add(task);
  }

  public Task getTaskId(int taskID)
  {
    for(Task task:list)
    {
      if(task.getId() == taskID)
        return task;
    }
    return null;
  }

  public Task getTaskIndex(int index)
  {
    return list.get(index);
  }

  public void removeTask(Task task)
  {
    list.remove(task);
  }

  public void removeTask(int taskID)
  {
    list.removeIf(task -> task.getId()==taskID);
  }

  public int numberOfTasks()
  {
    return list.size();
  }

  public ArrayList<Task> getTaskByStatus(String status){
    ArrayList<Task> tasks=new ArrayList<>();
    for(Task task:list)
      if(task.getStatus().equals(status))
        tasks.add(task);
    return tasks;
  }

  @Override public String toString()
  {
    StringBuilder arrayAsString = new StringBuilder("Tasks\n");
    for(Task task:list)
    {
      arrayAsString.append(task.toString()).append("\n");
    }
    return arrayAsString.toString();
  }

}
