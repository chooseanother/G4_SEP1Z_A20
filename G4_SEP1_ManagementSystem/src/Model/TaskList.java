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
   * @param taskID of task to fetch
   * @return a {@link Task}
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

  /**
   * Returns a task specified by provided index
   * @param index of task to fetch
   * @return a {@link Task}
   */
  public Task getTaskIndex(int index)
  {
    return list.get(index);
  }

  /**
   * Removes specified {@link Task} object from a {@link TaskList}
   * @param task to be removed
   */
  public void removeTask(Task task)
  {
    list.remove(task);
  }

  /**
   * Removes a {@link Task} object specified by id, from a {@link TaskList}
   * @param taskID of task to remove
   */
  public void removeTask(int taskID)
  {
    list.removeIf(task -> task.getId()==taskID);
  }

  /**
   * Returns amount of {@link Task} in a {@link TaskList}
   * @return amount of tasks as an {@link Integer}
   */
  public int numberOfTasks()
  {
    return list.size();
  }
/**
 * Returns an {@link ArrayList} of {@link Task} with the specified status
 * @param status as a {@link String}
 * @return an {@link ArrayList} of {@link Task} with the specified status
 */
  public ArrayList<Task> getTaskByStatus(String status){
    ArrayList<Task> tasks=new ArrayList<>();
    for(Task task:list)
      if(task.getStatus().equals(new Status(false,status)))
        tasks.add(task);
    return tasks;
  }

  /**
   * Creates a string containing information of all tasks in a task list
   * @return a {@link String}
   */
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
