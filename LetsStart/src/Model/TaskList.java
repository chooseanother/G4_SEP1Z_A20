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
  public Task getTask(int index){
    return list.get(index);
  }
  public void removeTask(Task task)
  {
    list.remove(task);
  }
  public void removeTask(int index)
  {
    list.remove(index);
  }
  public void removeTask(String taskID)
  {
    for(Task task:list)
    {
      if(task.getTaskID().equals(taskID)){
        list.remove(task);
      }
    }
  }
  public int numberOfTasks()
  {
    return list.size();
  }
  public ArrayList<Task> getTaskByStatus(Status status){
    ArrayList<Task> tasks=new ArrayList<>();
    for(Task task:list)
      if(task.getStatus().equals(status))
        tasks.add(task);
    return tasks;
  }
  @Override public String toString()
  {
    String s="";
    for(Task task:list)
    {
      if(!task.equals(null))
       s=s+" "+task;
    }
    return s;
  }

}
