package ListView;

import Model.ManagementSystemModel;
import Model.Requirement;
import View.ViewState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RequirementListViewModel
{
  private ObservableList<RequirementViewModel> list;
  private ManagementSystemModel model;
  private int projectId;

  public RequirementListViewModel(ManagementSystemModel model, ViewState state){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.projectId = state.getProjectId();
    update();
  }

  public ObservableList<RequirementViewModel> getList(){
    return list;
  }

  public void update(){
    list.clear();
    for (int i = 0; i < model.getProject(projectId).getRequirementList().
        getNumberOfRequirements(); i++){
      list.add(new RequirementViewModel(
          model.getProject(projectId).getRequirementList()
              .getRequirementIndex(i)));
    }
  }

  public void add(Requirement requirement){
    list.add(new RequirementViewModel(requirement));
  }

  public void remove(Requirement requirement){
    for (RequirementViewModel r : list){
      if(r.getIdProperty() == requirement.getId()){
        list.remove(r);
        break;
      }
    }
  }
}
