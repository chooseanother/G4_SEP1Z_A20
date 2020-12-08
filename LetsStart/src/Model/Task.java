package Model;

public class Task {

  private String title;
  private int estimatedHours;
  private int totalHoursWorked;
  private int reqId;
  private TeamMember responsibleTeamMember;
  private Status status;
  private MyDate deadline;
  private Id id;
  private TeamMemberList teamMemberList;

  public Task(String title, int estimatedTime, MyDate deadline, TeamMember responsibleTeamMember, int reqId) {
    this.title = title;
    this.estimatedHours = estimatedTime;

  }

  public void updateStatus(String status) {
    this.status.setStatus(status);
  }

  public void updateHoursSpent(int hours) {
    totalHoursWorked += hours;
  }

  public void changeResponsibleTeamMember(TeamMember responsibleTeamMember) {

  }

  public int getId() {
    return 0;
  }

  public String getTitle() {
    return null;
  }

  public MyDate getDeadline() {
    return null;
  }

  public int getEstimatedTime() {
    return 0;
  }

  public int getHoursSpent() {
    return 0;
  }

  public TeamMember getResponsibleTeamMember() {
    return null;
  }

  public String toString() {
    return null;
  }

  public boolean equals(Object obj) {
    return false;
  }

  public void addTeamMember(TeamMember teamMember) {

  }

  public TeamMemberList getAllTeamMembers() {
    return null;
  }

  public int getReqId() {
    return 0;
  }

}