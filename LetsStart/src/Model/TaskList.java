package Model;

import java.util.ArrayList;

/**
 * Handles an {@link ArrayList} of {@link Task} objects
 *
 * @author Kim
 */
public class TaskList
{
  private ArrayList<Task> list;

  /**
   * Initialization of {@link ArrayList}
   */
  public TaskList()
  {
    list=new ArrayList<>();
  }

  /**
   * Adds a task to a {@link TaskList}
   * @param task that has to be added
   */
  public void addTask(Task task){
    list.add(task);
  }

  /**
   * Returns a task specified by provided id
   * @param taskID
   * @return
   */
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
      if(task.getStatus().equals(new Status(false,status)))
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
