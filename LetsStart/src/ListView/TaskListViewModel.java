package ListView;

import Model.ManagementSystemModel;
import Model.Task;
import View.ViewState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskListViewModel
{
  private ObservableList<TaskViewModel> list;
  private ManagementSystemModel model;
  private int projectId, requirementId;

  public TaskListViewModel(ManagementSystemModel model, ViewState state){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.projectId = state.getProjectId();
    this.requirementId = state.getRequirementId();
    update();
  }

  public ObservableList<TaskViewModel> getList(){
    return list;
  }

  public void update(){
    list.clear();
    for(int i = 0;
        i < model.getProject(projectId).getRequirementList().
            getRequirementId(requirementId).getAllTasks().numberOfTasks(); i++){
      list.add(new TaskViewModel(model.getRequirement(projectId,requirementId).getAllTasks().getTaskIndex(i)));
    }
  }

  public void add(Task task){
    list.add(new TaskViewModel(task));
  }

  public void remove(Task task){
    for (TaskViewModel t:list){
      if (t.getIdProperty() == task.getId()){
        list.remove(t);
        break;
      }
    }
  }
}
