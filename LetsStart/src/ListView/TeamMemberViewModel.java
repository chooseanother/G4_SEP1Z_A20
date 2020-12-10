package ListView;

import Model.TeamMember;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TeamMemberViewModel
{
  private StringProperty nameProperty;
  private StringProperty roleProperty;

  public TeamMemberViewModel(TeamMember teamMember) {
    nameProperty =
        new SimpleStringProperty(teamMember.getName().getFullName());
    roleProperty =
        new SimpleStringProperty(teamMember.getRole().getRole());
  }

  public String getNameProperty()
  {
    return nameProperty.get();
  }

  public StringProperty namePropertyProperty()
  {
    return nameProperty;
  }

  public String getRoleProperty()
  {
    return roleProperty.get();
  }

  public StringProperty rolePropertyProperty()
  {
    return roleProperty;
  }
}
