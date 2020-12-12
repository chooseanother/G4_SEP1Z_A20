package ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.TeamMember;
import Model.ManagementSystemModel;
import View.ViewState;

public class TeamMemberListViewModel
{

  private ObservableList<TeamMemberViewModel> list;
  private ManagementSystemModel model;
  private ViewState state;

  public TeamMemberListViewModel(ManagementSystemModel model, ViewState state)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.state = state;
    update();
  }

  public ObservableList<TeamMemberViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    if(state.getProjectId() > 0)
    {
      for (int i = 0; i < model.getProject(state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++)
      {
        list.add(new TeamMemberViewModel(
            model.getProject(state.getProjectId()).getTeamMemberList().getTeamMember(i)));
      }
    }
  }

  public void add(TeamMember member)
  {
    list.add(new TeamMemberViewModel(member));
  }

  public void remove(TeamMember member)
  {
    for (TeamMemberViewModel t : list){
      if (t.getNameProperty().equals(member.getName().getFullName())
          && t.getRoleProperty().equals(member.getRole().getRole()))
      {
        list.remove(t);
        break;
      }
    }
  }
}
