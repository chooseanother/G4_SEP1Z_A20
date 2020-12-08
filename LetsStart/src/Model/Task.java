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
    return deadline;
  }

  public int getEstimatedTime() {
    return estimatedHours;
  }

  public int getHoursSpent() {
    return totalHoursWorked;
  }

  public Status getStatus(){
    return status;
  }

  public TeamMember getResponsibleTeamMember() {
    return responsibleTeamMember;
  }

  public boolean equals(Object obj) {
    if (this == obj){
      return true;
    }
    if (obj == null){
      return false;
    }
    if (!(obj instanceof Task)){
      return false;
    }
    Task comp = (Task) obj;
    return id.equals(comp.id);
  }

  public String toString() {
    return title +
        "\nID: "+id+
        "\nRequirement Id: "+ reqId+
        "\nDeadline: "+ deadline.toString()+
        "\nStatus: "+ status+
        "\nEstimated time: "+ estimatedHours +
        "\nHours spend: " + totalHoursWorked +
        "\nResponsible: " + responsibleTeamMember.toString()+
        "\nAssigned employees: " + teamMemberList.toString();
  }
}