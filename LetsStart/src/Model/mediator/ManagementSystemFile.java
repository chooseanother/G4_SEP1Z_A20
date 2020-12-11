package Model.mediator;

import Model.ProjectList;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

public class ManagementSystemFile implements ManagementSystemPersistence
{
  XmlJsonParser parser = new XmlJsonParser();

  @Override public void save(ProjectList projectList, String fileName)
  {
    File file = null;
    try
    {
      file = parser.toJson(projectList, fileName);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
    System.out.println("Saved to file: " + file.getAbsolutePath());
  }

  @Override public ProjectList load(String fileName)
  {
    ProjectList projectList = new ProjectList();
    try
    {
      projectList = parser.fromJson(fileName, ProjectList.class);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
    System.out.println("Loaded from file: " + fileName);
    return projectList;
  }
}
