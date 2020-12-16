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
   * @param responsibleTeamMember of requirement as a {@link TeamMember}
   * @param estimatedTime for a requirement as an {@link Integer}
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

  /**
   * Returns all tasks of a requirement
   * @return a {@link TaskList}
   */
  public TaskList getAllTasks()
  {
    return tasks;
  }

  /**
   * Returns a requirements deadline
   * @return {@link MyDate}
   */
  public MyDate getDeadline()
  {
    return deadline;
  }

  /**
   * Returns a requirements estimated time
   * @return estimated time as an{@link Integer}
   */
  public int getEstimatedTime()
  {
    return estimatedTime;
  }

  /**
   * Returns a requirements id
   * @return id as an {@link Integer}
   */
  public int getId()
  {
    return reqID.getId();
  }

  /**
   * Returns a requirements description
   * @return description as a {@link String}
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Updates total time spent, to a total, of spent time on all tasks, related to a requirement, then returns it
   * @return total time spent as an {@link Integer}
   */
  public int getTimeSpent()
  {
    updateTotalHoursSpent();
    return timeSpent;
  }

  /**
   * Returns the status of a requirement
   * @return {@link Status}
   */
  public Status getStatus()
  {
    return status;
  }

  /**
   * Returns the priority of a requirement
   * @return {@link Priority}
   */
  public Priority getPriority()
  {
    return priority;
  }

  /**
   * Returns the responsible team member of a requirement
   * @return {@link TeamMember}
   */
  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  /**
   * Changes responsible team member to specified parameter
   * @param teamMember in form of {@link TeamMember}
   */
  public void changeResponsibleTeamMember(TeamMember teamMember){
    this.responsibleTeamMember = teamMember;
  }

  /**
   * Changes the status of a requirement to specified parameter
   * @param status as a {@link String}
   */
  public void setStatus(String status){
    this.status.setStatus(status);
  }

  /**
   * Updates the status of a requirement, based on the status of all related tasks
   */
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

  /**
   * Changes the priority of a requirement
   * @param priority as a {@link Priority}
   */
  public void setPriority(Priority priority)
  {
    this.priority=priority;
  }

  /**
   * Updates total time spent, to a total, of spent time on all tasks related to a requirement
   */
  public void updateTotalHoursSpent()
  {
    int total = 0;
    for (int i = 0 ; i < tasks.numberOfTasks(); i++){
      total += tasks.getTaskIndex(i).getHoursSpent();
    }
    timeSpent = total;
  }

  /**
   * Sets estimated time to specified parameter
   * @param time estimation as an {@link Integer}
   */
  public void setEstimatedTime(int time)
  {
    estimatedTime = time;
  }

  /**
   * Sets description to specified parameter
   * @param description as a {@link String}
   */
  public void setDescription(String description){
    this.description = description;
  }

  /**
   * Creates a string containing all information from a requirement
   * @return a {@link String}
   */
  @Override public String toString()
  {
    return "Requirement id: "+reqID+
        "\n"+description+
        "\nTime spent: "+timeSpent+
        "\nEstimated time: "+estimatedTime+
        "\nDeadline: "+deadline.toString()+
        "\nStatus: "+status.toString()+
        "\nPriority: "+priority.toString()+
        "\nResponsible team member: "+responsibleTeamMember.toString()+
        "\n"+tasks.toString();
  }

}
