package View;

import Model.ManagementSystemModel;
import javafx.scene.layout.Region;

public class TaskViewController
{
  private Region root;
  private ViewHandler viewHandler;
  private ManagementSystemModel managementSystemModel;
  private ViewState state;

  public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root, ViewState state) {
    this.viewHandler = viewHandler;
    this.managementSystemModel = model;
    this.root = root;
    if (state.getTaskId()>0)
    {
      root.setUserData("Task");
    }
    else
      root.setUserData("New Task");

  }

  public void reset() {

    if (state.getTaskId()>0)
    {
      root.setUserData("Task");
    }
    else
      root.setUserData("New Task");

  }
  //check if estimated time is allowed
  // (estimated time for requirement minus total estimated time from all tasks
  // related to requirement should be above estimated time form a new task
  // else there will be an error/warning)
  public Region getRoot() {
    return root;
  }
}
