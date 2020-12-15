package View.ListView;

import Model.Project;
import javafx.beans.property.*;

public class ProjectViewModel
{
  private StringProperty titleProperty;
  private StringProperty progressProperty;
  private StringProperty deadlineProperty;
  private IntegerProperty idProperty;

  public ProjectViewModel(Project project) {
    titleProperty =
        new SimpleStringProperty(project.getTitle());
    deadlineProperty =
        new SimpleStringProperty(project.getDeadline().toString());
    progressProperty =
        new SimpleStringProperty(project.getProgress()+"%");
    idProperty = new SimpleIntegerProperty(project.getId());

  }

  public String getTitleProperty()
  {
    return titleProperty.get();
  }

  public StringProperty titlePropertyProperty()
  {
    return titleProperty;
  }

  public String getProgressProperty()
  {
    return progressProperty.get();
  }

  public StringProperty progressPropertyProperty()
  {
    return progressProperty;
  }

  public String getDeadlineProperty()
  {
    return deadlineProperty.get();
  }

  public StringProperty deadlinePropertyProperty()
  {
    return deadlineProperty;
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
