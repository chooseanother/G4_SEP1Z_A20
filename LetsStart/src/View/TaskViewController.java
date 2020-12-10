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
  }

  public void reset() {

  }

  public Region getRoot() {
    return root;
  }
}
