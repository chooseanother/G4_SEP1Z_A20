package View.ListView;

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
    if(state.getProjectId() > 0 && model.getAllTeamMembers(state.getProjectId()).numberOfTeamMembers()>0)
    {
      for (int i = 0; i < model.getProject(state.getProjectId()).getTeamMemberList().numberOfTeamMembers(); i++)
      {
        list.add(new TeamMemberViewModel(
            model.getAllTeamMembers(state.getProjectId()).getTeamMemberIndex(i)));
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
      if (t.getIdProperty() == member.getId())
      {
        list.remove(t);
        break;
      }
    }
  }
}
