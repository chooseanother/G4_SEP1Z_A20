package Model;

public class Requirement
{
  public String getReqID()
  {
    return reqID;
  }

  public String getDescription()
  {
    return description;
  }

  public int getTimeSpent()
  {
    return timeSpent;
  }

  public int getEstimatedTime()
  {
    return estimatedTime;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public TaskList getTasks()
  {
    return tasks;
  }

  public Status getStatus()
  {
    return status;
  }

  public Priority getPriority()
  {
    return priority;
  }

  public TeamMemberList getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  private String reqID;
  private String description;
  private int timeSpent;
  private int estimatedTime;
  private MyDate deadline;
  private TaskList tasks;
  private Status status;
  private Priority priority;
  private TeamMemberList responsibleTeamMember;

  public Requirement(String reqID, String description, int timeSpent, int estimatedTime, MyDate deadline, TaskList tasks, Status status, Priority priority, TeamMemberList responsibleTeamMember)
  {
    this.reqID = reqID;
    this.description = description;
    this.timeSpent = timeSpent;
    this.estimatedTime = estimatedTime;
    this.deadline = deadline;
    this.tasks = tasks;
    this.status = status;
    this.priority = priority;
    this.responsibleTeamMember = responsibleTeamMember;
  }
  public void updateStatus (Status status)
  {
    this.status.update(status);
  }
  public void addTask(Task task, String reqID){
    this.reqID=reqID;
    tasks.addTask(task);
  }
  public void removeTask(Task task)
  {
    tasks.removeTask(task);
  }
  public void removeTask(int index)
  {
    tasks.removeTask(index);
  }
  public void removeTask(String taskID)
  {
        tasks.removeTask(taskID);
  }
  public Task getTask(String taskID)
  {
    return tasks.getTask(taskID);
  }
  public Task getTask(int index)
  {
    return tasks.getTask(index);
  }
  public void updateTotalHoursSpent(int hoursWorked)
  {
    timeSpent+=hoursWorked;
  }
  @Override public String toString()
  {
    String s="";
    s+=reqID+" "+description+" "+timeSpent+" "+estimatedTime+" "+deadline.toString()+" "+tasks.toString()+" "+status.toString()+" "+priority.toString()+" "+responsibleTeamMember.toString();
    return s;
  }

}
