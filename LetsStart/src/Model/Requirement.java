package Model;

/**
 * Handles all relevant information of a requirement
 *
 * @author Kim
 */
public class Requirement
{
  private Id reqID;
  private String description;
  private int timeSpent;
  private int estimatedTime;
  private MyDate deadline;
  private TaskList tasks;
  private Status status;
  private Priority priority;
  private TeamMember responsibleTeamMember;

  /**
   * Creates a {@link Requirement} based on given parameters.
   * <p>{@link Id} gives this an unique id</p>
   * <p>Remaining fields are initialized to default values</p>
   * @param description of a requirement as a {@link String}
   * @param deadline {@link MyDate} as the requirements deadline
   * @param priority of a requirement as a {@link Priority}
   * @param responsibleTeamMember of r
   * @param estimatedTime
   */
  public Requirement(String description, MyDate deadline, Priority priority, TeamMember responsibleTeamMember, int estimatedTime)
  {
    this.reqID = new Id();
    this.description = description;
    this.timeSpent = 0;
    this.estimatedTime = estimatedTime;
    this.deadline = deadline;
    this.tasks = new TaskList();
    this.status = new Status(true);
    this.priority = priority;
    this.responsibleTeamMember = responsibleTeamMember;
  }

  public TaskList getAllTasks()
  {
    return tasks;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public int getEstimatedTime()
  {
    return estimatedTime;
  }

  public int getId()
  {
    return reqID.getId();
  }

  public String getDescription()
  {
    return description;
  }

  public int getTimeSpent()
  {
    updateTotalHoursSpent();
    return timeSpent;
  }

  public Status getStatus()
  {
    return status;
  }

  public Priority getPriority()
  {
    return priority;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  public void changeResponsibleTeamMember(TeamMember teamMember){
    this.responsibleTeamMember = teamMember;
  }

  public void setStatus(String status){
    this.status.setStatus(status);
  }

  public void updateStatus ()
  {
    for (int i = 0; i < tasks.numberOfTasks();i++){
      if (!tasks.getTaskIndex(i).getStatus().toString().equals(Status.FINISHED)){
        status.setStatus(Status.IN_PROGRESS);
        return;
      }
    }
    if (tasks.numberOfTasks()>0){
      status.setStatus(Status.ENDED);
    }
    else {
      status.setStatus(Status.IN_PROGRESS);
    }
  }

  public void setPriority(Priority priority)
  {
    this.priority=priority;
  }

  public void updateTotalHoursSpent()
  {
    int total = 0;
    for (int i = 0 ; i < tasks.numberOfTasks(); i++){
      total += tasks.getTaskIndex(i).getHoursSpent();
    }
    timeSpent = total;
  }
  public void setEstimatedTime(int time)
  {
    estimatedTime = time;
  }

  public void setDescription(String description){
    this.description = description;
  }

  @Override public String toString()
  {
    String s="";
    s+=reqID+" "+description+" "+timeSpent+" "+estimatedTime+" "+deadline.toString()+" "+tasks.toString()+" "+status.toString()+" "+priority.toString()+" "+responsibleTeamMember.toString();
    return s;
  }

}
