package Model;

public class Project
{
  private double progress;
  private Id id;
  private Customer customer;
  private RequirementList requirementList;
  private TeamMemberList teamMemberList;
  private MyDate deadline;
  private String description;
  private String title;
  private int totalTime;

  public Project(String title, Customer customer, MyDate deadline, String description){
    this.title = title;
    this.customer=customer;
    this.deadline=deadline;
    this.description = description;
    requirementList=new RequirementList();
    teamMemberList=new TeamMemberList();
    id= new Id();
    progress=0;
    totalTime = 0;
  }

  public void updateProgress()
  {
    int count=0;
    for(int i = 0; i < requirementList.getNumberOfRequirements(); i++)
    {
      requirementList.getRequirementIndex(i).updateStatus();
      if(requirementList.getRequirementIndex(i).getStatus().equals(new Status(true,Status.APPROVED))||
          requirementList.getRequirementIndex(i).getStatus().equals(new Status(true,Status.ENDED)))
        count++;
    }
    progress=(double)count*100/requirementList.getNumberOfRequirements();
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  public double getProgress() {
    return progress;
  }

  public Customer getCustomer() {
    return customer;
  }

  public MyDate getDeadline() {
    return deadline;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public int getId(){
    return id.getId();
  }

  public TeamMemberList getTeamMemberList() {
    return teamMemberList;
  }

  public RequirementList getRequirementList() {
    return requirementList;
  }

  public int getTotalHoursSpent() {
    int sum=0;
    for(int i=0;i<requirementList.getNumberOfRequirements();i++)
      sum+=requirementList.getRequirementIndex(i).getTimeSpent();
    totalTime = sum;
    return totalTime;
  }

  public void addRequirement(Requirement requirement){
    requirementList.addRequirement(requirement);
  }

  @Override public String toString() {
    return id+" "+ progress+" "+customer.toString()+" "+requirementList.toString()+" "+teamMemberList.toString()+" "+deadline.toString();
  }


}
