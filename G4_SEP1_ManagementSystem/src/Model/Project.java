package Model;

/**
 * Handles all relevant information about a project
 */
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

  /**
   * Creates a {@link Project} based on given parameters.
   * <p>{@link Id} gives this an unique id</p>
   * <p>Remaining fields are initialized to default values</p>
   * @param title a {@link String} with the title of a project
   * @param customer {@link Customer} for a project
   * @param deadline {@link MyDate} as the projects deadline
   * @param description of a project as a {@link String}
   */
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

  /**
   * Updates the progress of a project.
   * <p>Updates and checks status of all related requirements</p>
   */
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

  /**
   * Sets the customer of a project
   * @param customer of type {@link Customer}
   */
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  /**
   * Gets the description of a project
   * @return the description as a {@link String}
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Sets the description of a project
   * @param description {@link String}
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * Sets the deadline of a project
   * @param deadline {@link MyDate}
   */
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  /**
   * Gets the progress of a project
   * @return progress as a {@link Double}
   */
  public double getProgress() {
    return progress;
  }

  /**
   * Gets the customer of a project
   * @return {@link Customer}
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Gets the deadline of a project
   * @return deadline as a {@link MyDate} object
   */
  public MyDate getDeadline() {
    return deadline;
  }

  /**
   * Gets the title of a project
   * @return title as a {@link String}
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * Sets the title of a project
   * @param title as a {@link String}
   */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * Gets the id of a project
   * @return id as an {@link Integer}
   */
  public int getId(){
    return id.getId();
  }

  /**
   * Gets the list of team members assigned to a project
   * @return {@link TeamMemberList}
   */
  public TeamMemberList getTeamMemberList() {
    return teamMemberList;
  }

  /**
   * Gets the list of a projects requirements
   * @return {@link RequirementList}
   */
  public RequirementList getRequirementList() {
    return requirementList;
  }

  /**
   * Updates and gets the total amount of hours worked on all related requirements for a project
   * @return total time spent as an {@link Integer}
   */
  public int getTotalHoursSpent() {
    int sum=0;
    for(int i=0;i<requirementList.getNumberOfRequirements();i++)
      sum+=requirementList.getRequirementIndex(i).getTimeSpent();
    totalTime = sum;
    return totalTime;
  }

  /**
   * Adds a requirement to a project
   * @param requirement of type {@link Requirement}
   */
  public void addRequirement(Requirement requirement){
    requirementList.addRequirement(requirement);
  }

  /**
   * Converts all relevant information about a project into a {@link String}
   * @return a {@link String}
   */
  @Override public String toString() {
    return id+" "+ progress+" "+customer.toString()+" "+requirementList.toString()+" "+teamMemberList.toString()+" "+deadline.toString();
  }


}
