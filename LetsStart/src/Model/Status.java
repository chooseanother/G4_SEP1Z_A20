package Model;

public class Status
{
  public static final String ENDED_STATUS="Ended";
  public static final String STARTED_STATUS="Started";
  public static final String NOT_STARTED_STATUS="Not started";
  public static final String IN_PROGRESS_STATUS="In progress";
  public static final String APPROVED_STATUS="Approved";
  public static final String REJECTED_STATUS="Rejected";
  private String status;
  private boolean isRequirement;
  public Status(boolean isRequirement)
  {
    this.isRequirement=isRequirement;
    if(isRequirement)
    {
      status=IN_PROGRESS_STATUS;
    }
    else
    {
      status=NOT_STARTED_STATUS;
    }
  }
  public void update(Status status){
    this.status=status;
  }
  public String getStatus(){
    return status;
  }
  @Override public boolean equals(Object obj)
  {
    if(!(obj instanceof String))
      return false;
    String other=(String) obj;
    return status.equals(other);
  }
  @Override public String toString()
  {
    return status;
  }
}
