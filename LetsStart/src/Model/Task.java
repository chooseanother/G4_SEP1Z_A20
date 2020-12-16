package Model;

/**
 * Stores all information related to a task
 *
 * @author Kim
 */
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

  /**
   * Initializes passed variables, and initializes the rest to default values
   * @param title name of task
   * @param estimatedTime time needed to finish a task
   * @param deadline when a task should be done
   * @param responsibleTeamMember who has responsibility
   * @param reqId id of related requirement
   */
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

  /**
   * Sets title
   * @param title title as a {@link String}
   */
  public void setTitle(String title){
    this.title = title;
  }

  /**
   * Sets estimated amount of hours needed
   * @param estimate hours as an {@link Integer}
   */
  public void setEstimatedHours(int estimate){
    this.estimatedHours = estimate;
  }

  /**
   * Sets status
   * @param status status as a string taken from {@link Status} public fields
   */
  public void updateStatus(String status) {
    this.status.setStatus(status);
  }

  /**
   * Adds specified hours to the total
   * @param hours amount worked in hours as {@link Integer} (erm probably should have been double or float, unless they only get paid by every whole hour)
   */
  public void updateHoursSpent(int hours) {
    totalHoursWorked += hours;
  }

  /**
   * Sets responsible team member for a task
   * @param responsibleTeamMember {@link TeamMember} object
   */
  public void changeResponsibleTeamMember(TeamMember responsibleTeamMember) {
    this.responsibleTeamMember = responsibleTeamMember;
  }
  public void addTeamMember(TeamMember teamMember) {
    teamMemberList.addTeamMember(teamMember);
  }

  /**
   * Removes a team member from a task, based on specified id
   * @param id as an {@link Integer}
   */
  public void removeTeamMember(int id){
    teamMemberList.removeTeamMember(id);
  }

  /**
   * Removes a specified team member from a task
   * @param teamMember team member that is going to be removed
   */
  public void removeTeamMember(TeamMember teamMember){
    teamMemberList.removeTeamMember(teamMember);
  }

  /**
   * Returns id of a task
   * @return id as an {@link Integer}
   */
  public int getId() {
    return id.getId();
  }

  /**
   * Returns id of related requirement
   * @return id as an {@link Integer}
   */
  public int getReqId() {
    return reqId;
  }

  /**
   * Returns all team members related to a task
   * @return {@link TeamMemberList} object
   */
  public TeamMemberList getAllTeamMembers() {
    return teamMemberList;
  }

  /**
   * Returns title of a task
   * @return title as a {@link String}
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns deadline of a task
   * @return a {@link MyDate} object
   */
  public MyDate getDeadline() {
    return deadline;
  }

  /**
   * Returns estimated time for a task
   * @return estimated time as an {@link String}
   */
  public int getEstimatedTime() {
    return estimatedHours;
  }

  /**
   * Returns total amount of hours worked on a task
   * @return total amount of hours worked as an {@link Integer}
   */
  public int getHoursSpent() {
    return totalHoursWorked;
  }

  /**
   * Returns the status of a task
   * @return {@link Status} object of a task
   */
  public Status getStatus(){
    return status;
  }

  /**
   * Returns responsible team member of a task
   * @return {@link TeamMember} object
   */
  public TeamMember getResponsibleTeamMember() {
    return responsibleTeamMember;
  }

  /**
   * Compares another object with current task object
   *
   * @param obj object you want to compare
   * @return returns the result of comparing the two objects as boolean
   */
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

  /**
   * Creates a string with all information related to a task
   * @return a {@link String}
   */
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