package View.ListView;

import Model.ManagementSystemModel;
import Model.Task;
import View.ViewState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskListViewModel
{
  private ObservableList<TaskViewModel> list;
  private ManagementSystemModel model;
  private ViewState state;

  public TaskListViewModel(ManagementSystemModel model, ViewState state){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.state = state;
    update();
  }

  public ObservableList<TaskViewModel> getList(){
    return list;
  }

  public void update(){
    list.clear();
    if (state.getRequirementId()>0)
    {
      for (int i = 0; i < model.getProject(state.getProjectId()).getRequirementList().
          getRequirementId(state.getRequirementId()).getAllTasks().numberOfTasks(); i++)
      {
        list.add(new TaskViewModel(
            model.getRequirement(state.getProjectId(), state.getRequirementId()).getAllTasks().getTaskIndex(i)));
      }
    }
  }

  public void add(Task task){
    list.add(new TaskViewModel(task));
  }

  public void remove(int id){
    for (TaskViewModel t:list){
      if (t.getIdProperty() == id){
        list.remove(t);
        break;
      }
    }
  }
}
