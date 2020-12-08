package Model;

public class Status
{
  public static final String ENDED="Ended";
  public static final String STARTED="Started";
  public static final String NOT_STARTED="Not started";
  public static final String FINISHED="Finished";
  public static final String IN_PROGRESS="In progress";
  public static final String APPROVED="Approved";
  public static final String REJECTED="Rejected";
  private String status;
  private boolean isRequirement;

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

  public Status(boolean isRequirement, String status)
  {
    this.isRequirement=isRequirement;
    this.status = status;
  }

  public void setStatus(String status){
    if (isRequirement && status.equalsIgnoreCase(REJECTED) || status.equalsIgnoreCase(APPROVED) || status.equalsIgnoreCase(ENDED) || status.equalsIgnoreCase(IN_PROGRESS))
      this.status=status;
    else if (!isRequirement && status.equalsIgnoreCase(NOT_STARTED) || status.equalsIgnoreCase(STARTED) || status.equalsIgnoreCase(FINISHED)){
      this.status = status;
    }
  }

  public String getStatus(){
    return status;
  }

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

  @Override public String toString()
  {
    return status;
  }
}
