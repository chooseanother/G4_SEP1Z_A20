package ListView;

import Model.Requirement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RequirementViewModel
{
  private StringProperty descriptionProperty;
  private StringProperty priorityProperty;
  private StringProperty statusProperty;
  private IntegerProperty idProperty;

  public RequirementViewModel(Requirement requirement){
    descriptionProperty =
        new SimpleStringProperty(requirement.getDescription());
    priorityProperty =
        new SimpleStringProperty(requirement.getPriority().toString());
    statusProperty =
        new SimpleStringProperty(requirement.getStatus().toString());
    idProperty = new SimpleIntegerProperty(requirement.getId());
  }

  public String getDescriptionProperty()
  {
    return descriptionProperty.get();
  }

  public StringProperty descriptionPropertyProperty()
  {
    return descriptionProperty;
  }

  public String getPriorityProperty()
  {
    return priorityProperty.get();
  }

  public StringProperty priorityPropertyProperty()
  {
    return priorityProperty;
  }

  public String getStatusProperty()
  {
    return statusProperty.get();
  }

  public StringProperty statusPropertyProperty()
  {
    return statusProperty;
  }

  public int getIdProperty()
  {
    return idProperty.get();
  }

  public IntegerProperty idPropertyProperty()
  {
    return idProperty;
  }
}
