package View.ListView;

import Model.Task;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaskViewModel
{
  private StringProperty titleProperty;
  private StringProperty statusProperty;
  private IntegerProperty idProperty;

  public TaskViewModel(Task task) {
    titleProperty = new SimpleStringProperty(task.getTitle());
    statusProperty = new SimpleStringProperty(task.getStatus().getStatus());
    idProperty = new SimpleIntegerProperty(task.getId());
  }

  public String getTitleProperty()
  {
    return titleProperty.get();
  }

  public StringProperty titlePropertyProperty()
  {
    return titleProperty;
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
