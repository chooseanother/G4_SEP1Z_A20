package View.ListView;

import Model.ManagementSystemModel;
import Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectListViewModel
{
  private ObservableList<ProjectViewModel> list;
  private ManagementSystemModel model;

  public ProjectListViewModel(ManagementSystemModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<ProjectViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getAllProjects().numberOfProjects(); i++)
    {
      Project tmp = model.getAllProjects().getProjectIndex(i);
      if (tmp.getRequirementList().getNumberOfRequirements()>0){
        model.updateProjectProgress(tmp.getId());
      }
      list.add(new ProjectViewModel(tmp));
    }
  }

  public void add(Project project)
  {
    list.add(new ProjectViewModel(project));
  }

  public void remove(int projectId)
  {
    for (ProjectViewModel p : list) {
      if(p.getIdProperty() == projectId) {
        list.remove(p);
        break;
      }
    }
  }
}
