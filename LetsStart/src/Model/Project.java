package Model;

public class Project
{
  private double progress;
  private String id;
  private Customer customer;
  private RequirementList requirementList;
  private TeamMemberList teamMemberList;
  private MyDate deadline;
  public Project(String id, TeamMemberList teamMemberList, RequirementList requirementList, Customer customer, MyDate deadline)
  {
    this.customer=customer;
    this.deadline=deadline;
    this.requirementList=requirementList;
    this.teamMemberList=teamMemberList;
    this.id=id;
    this.progress=0;
  }
  public void updateProgress()
  {
    int nr=0;
    for(int i=0;i<requirementList.getNumberOfRequirements();i++)
    {
      if(requirementList.getRequirement(i).getStatus().equals(Status.APPROVED_STATUS))
        nr++;
    }
    progress=nr*100/requirementList.getNumberOfRequirements();
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
  public TeamMemberList getTeamMemberList()
  {
    return teamMemberList;
  }
  public RequirementList getRequirementList()
  {
    return requirementList;
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
