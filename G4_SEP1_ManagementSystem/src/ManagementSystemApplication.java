import javafx.application.Application;
import javafx.stage.Stage;
import Model.*;
import View.ViewHandler;

public class ManagementSystemApplication extends Application
{
  public void start(Stage primaryStage){
    ManagementSystemModel MS = new ManagementSystem();
    ViewHandler view = new ViewHandler(MS);
    view.start(primaryStage);
  }
}
