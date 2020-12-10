package ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.TeamMember;
import Model.ManagementSystemModel;

/**
 * Add this in viewcontroller
 *
 *     @FXML private TableView<TeamMemberViewModel> teamMemberListTable;
 *     @FXML private TableColumn<TeamMemberViewModel, String> nameColumn;
 *     @FXML private TableColumn<TeamMemberViewModel, String> roleColumn;
 *
 *     this.teamMemberListViewModel = new TeamMemberListViewModel(ManagementSystem, projectId);
 *     nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
 *     roleColumn.setCellValueFactory(cellData -> cellData.getValue().getRoleProperty());
 *     teamMemberListTable.setItems(teamMemberListViewModel.getList());
 */

public class TeamMemberListViewModel
{

  private ObservableList<TeamMemberViewModel> list;
  private ManagementSystemModel model;
  private int projectId;

  public TeamMemberListViewModel(ManagementSystemModel model, int projectId)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.projectId = projectId;
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
