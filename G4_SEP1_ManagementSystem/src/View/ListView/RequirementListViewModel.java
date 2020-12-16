package View.ListView;

import Model.ManagementSystemModel;
import Model.Requirement;
import View.ViewState;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RequirementListViewModel
{
  private ObservableList<RequirementViewModel> list;
  private ManagementSystemModel model;
  private ViewState state;

  public RequirementListViewModel(ManagementSystemModel model, ViewState state){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.state = state;
    update();
  }

  public ObservableList<RequirementViewModel> getList(){
    return list;
  }

  public void update(){

    list.clear();
    if (state.getProjectId()>0)
    {
      for (int i = 0; i < model.getProject(state.getProjectId()).getRequirementList().
          getNumberOfRequirements(); i++)
      {
        list.add(new RequirementViewModel(
            model.getProject(state.getProjectId()).getRequirementList().getRequirementIndex(i)));
      }
    }
  }

  public void add(Requirement requirement){
    list.add(new RequirementViewModel(requirement));
  }

  public void remove(int id){
    for (RequirementViewModel r : list){
      if(r.getIdProperty() == id){
        list.remove(r);
        break;
      }
    }
  }
}
