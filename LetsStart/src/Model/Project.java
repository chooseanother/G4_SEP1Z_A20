package Model;

public class Project
{
  private double progress;
  private String id;
  private Customer customer;
  private RequirementList requirementList;
  private TeamMemberList teamMemberList;
  private MyDate deadline;
  private String description;
  public Project(String id, TeamMemberList teamMemberList, RequirementList requirementList, Customer customer, MyDate deadline, String description)
  {
    this.customer=customer;
    this.deadline=deadline;
    this.requirementList=requirementList;
    this.teamMemberList=teamMemberList;
    this.id=id;
    this.progress=0;
    this.description = description;

  }
  public void updateProgress()
  {
    int nr=0;
    for(int i=0;i<requirementList.getNumberOfRequirements();i++)
    {
      if(requirementList.getRequirement(i).getStatus().equals(Status.APPROVED))
        nr++;
    }
    progress=nr*100/requirementList.getNumberOfRequirements();
  }
  public void removeTeamMember(String ID)
  {
    teamMemberList.removeTeamMember(ID);
  }
  public void addTeamMember(TeamMember member)
  {
    teamMemberList.addTeamMember(member);
  }
  public void addRequirement(Requirement requirement)
  {
    requirementList.addRequirement(requirement);
  }

  public double getProgress()
  {
    return progress;
  }
  public MyDate getDeadline()
  {
    return deadline;
  }
  public String getId(){
    return id;
  }
  public TeamMemberList getTeamMemberList()
  {
    return teamMemberList;
  }
  public RequirementList getRequirementList()
  {
    return requirementList;
  }
  public void setDeadline(MyDate date)
  {
    deadline=date;
  }
  public int getTotalHoursSpent()
  {
    int sum=0;
    for(int i=0;i<requirementList.getNumberOfRequirements();i++)
      sum+=requirementList.getRequirement(i).getTimeSpent();
    return sum;
  }
  @Override public String toString()
  {
    return id+" "+ progress+" "+customer.toString()+" "+requirementList.toString()+" "+teamMemberList.toString()+" "+deadline.toString();
  }
}
