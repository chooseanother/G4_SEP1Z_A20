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
  private int projectId;
  private int requirementId;
  private int taskId;

  public TeamMemberListViewModel(ManagementSystemModel model, ViewState state)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.projectId = state.getProjectId();
    this.requirementId = state.getRequirementId();
    this.taskId = state.getTaskId();
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
