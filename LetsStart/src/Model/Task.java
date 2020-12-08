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
    this.deadline = deadline;
    this.responsibleTeamMember = responsibleTeamMember;
    this.reqId = reqId;
    totalHoursWorked = 0;
    this.status = new Status(false);
    this.id = new Id();
    this.teamMemberList = new TeamMemberList();
  }

  public void updateStatus(String status) {
    this.status.setStatus(status);
  }

  public void updateHoursSpent(int hours) {
    totalHoursWorked += hours;
  }

  public void changeResponsibleTeamMember(TeamMember responsibleTeamMember) {
    this.responsibleTeamMember = responsibleTeamMember;
  }
  public void addTeamMember(TeamMember teamMember) {
    teamMemberList.addTeamMember(teamMember);
  }

  public int getId() {
    return id.getId();
  }

  public int getReqId() {
    return reqId;
  }

  public TeamMemberList getAllTeamMembers() {
    return teamMemberList;
  }

  public String getTitle() {
    return title;
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



}