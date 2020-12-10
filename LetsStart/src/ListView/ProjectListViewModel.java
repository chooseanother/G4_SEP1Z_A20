package ListView;

import Model.ManagementSystemModel;
import Model.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectListViewModel
{
  private ObservableList<TeamMemberViewModel> list;
  private ManagementSystemModel model;


  public ProjectListViewModel(ManagementSystemModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();

    update();
  }

  public ObservableList<TeamMemberViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getProject(projectId).getTeamMemberList().numberOfTeamMembers(); i++)
    {
      list.add(new TeamMemberViewModel(model.getProject(projectId).getTeamMemberList().getTeamMember(i)));
    }
  }

  public void add(TeamMember member)
  {
    list.add(new TeamMemberViewModel(member));
  }

  public void remove(TeamMember member)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(member.getName().getFullName())
          && list.get(i).getRoleProperty().get().equals(member.getRole().getRole()))
      {
        list.remove(i);
        break;
      }
    }
  }
}
