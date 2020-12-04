package Model;

public class Task
{
  private String requirementID;

  public String getTaskID()
  {
    return taskID;
  }

  public String getTitle()
  {
    return title;
  }

  public int getEstimatedHours()
  {
    return estimatedHours;
  }

  public int getTotalHoursWorked()
  {
    return totalHoursWorked;
  }

  public Status getStatus()
  {
    return status;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  private String taskID;
  private String title;
  private int estimatedHours;
  private int totalHoursWorked;
  private Status status;
  private MyDate deadline;
  private TeamMember responsibleTeamMember;
  public Task(String requirementID, String taskID, String title,int estimatedHours, MyDate deadline, TeamMember responsibleTeamMember, Status status)
  {
    this.requirementID=requirementID;
    this.taskID=taskID;
    this.title=title;
    this.estimatedHours=estimatedHours;
    this.deadline=deadline;
    this.responsibleTeamMember=responsibleTeamMember;
    this.status=status;
    totalHoursWorked=0;
  }
  public void updateStatus(String status)
  {
    this.status.update(status);
  }
  public void updateHoursSpent(int hours)
  {
    totalHoursWorked=hours;
  }
  public void updateResponsibleTeamMember(TeamMember responsibleTeamMember)
  {
    this.responsibleTeamMember=responsibleTeamMember;
  }
  public String getRequirementID()
  {
    return requirementID;
  }
  @Override public String toString()
  {
    return requirementID+" "+title+" "+taskID+" "+responsibleTeamMember.toString()+" "+estimatedHours+" "+deadline.toString()+" "+status.toString();
  }
}
