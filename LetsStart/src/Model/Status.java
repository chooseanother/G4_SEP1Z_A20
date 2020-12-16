package Model;

/**
 * Class that keeps track of requirement and task status.
 * @author Kim
 */
public class Status
{
  /**
   * public field that makes sure status is in correct format
   */
  public static final String ENDED="Ended";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String STARTED="Started";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String NOT_STARTED="Not started";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String FINISHED="Finished";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String IN_PROGRESS="In progress";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String APPROVED="Approved";
  /**
   * public field that makes sure status is in correct format
   */
  public static final String REJECTED="Rejected";
  /**
   * field that stores current status
   */
  private String status;
  /**
   * used to check if status is related to requirement or task
   */
  private boolean isRequirement;

  /**
   * Initializes status dependent on isRequirement
   * @param isRequirement keeps track if status is related to requirement or task
   */
  public Status(boolean isRequirement)
  {
    this.isRequirement=isRequirement;
    if(isRequirement)
    {
      status=IN_PROGRESS;
    }
    else
    {
      status=NOT_STARTED;
    }
  }

  /**
   * Initializes status and isRequirement to specified parameters
   * @param isRequirement true for requirement false for task
   * @param status any of the available {@link Status} class statuses
   */
  public Status(boolean isRequirement, String status)
  {
    this.isRequirement=isRequirement;
    this.status = status;
  }

  /**
   * sets the status to specified status
   * @param status any of the available {@link Status} class statuses
   */
  public void setStatus(String status){
    if (isRequirement && status.equalsIgnoreCase(REJECTED) || status.equalsIgnoreCase(APPROVED) || status.equalsIgnoreCase(ENDED) || status.equalsIgnoreCase(IN_PROGRESS))
      this.status=status;
    else if (!isRequirement && status.equalsIgnoreCase(NOT_STARTED) || status.equalsIgnoreCase(STARTED) || status.equalsIgnoreCase(FINISHED)){
      this.status = status;
    }
  }

  /**
   * Simple getter for status
   * @return {@link Status} object
   */
  public String getStatus(){
    return status;
  }

  /**
   * Compares another object with current Status object
   *
   * @param obj object you want to compare
   * @return the result of comparing the two objects as boolean
   */
  @Override public boolean equals(Object obj)
  {
    if (this == obj){
      return true;
    }
    if(obj == null){
      return false;
    }
    if(!(obj instanceof Status))
      return false;
    Status other=(Status) obj;
    return status.equals(other.getStatus()) && isRequirement == other.isRequirement;
  }

  /**
   * Returns the status
   *
   * @return the status as a string
   */
  @Override public String toString()
  {
    return status;
  }
}
