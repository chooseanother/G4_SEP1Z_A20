package View;

public class ViewState
{
  private int projectId;
  private int requirementId;
  private int taskId;


  public ViewState(){
    projectId = -1;
    requirementId = -1;
    taskId = -1;

  }

  public int getProjectId()
  {
    return projectId;
  }

  public void setProjectId(int projectId)
  {
    this.projectId = projectId;
  }

  public int getRequirementId()
  {
    return requirementId;
  }

  public void setRequirementId(int requirementId)
  {
    this.requirementId = requirementId;
  }

  public int getTaskId()
  {
    return taskId;
  }

  public void setTaskId(int taskId)
  {
    this.taskId = taskId;
  }

}
