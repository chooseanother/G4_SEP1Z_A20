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
    String filenameParse = "config.xml";
    File file = null;
    try
    {
      file = parser.toXml(projectList, fileName);
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
      projectList = parser.fromXml(fileName, ProjectList.class);
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
    System.out.println("Loaded from file: " + fileName);
    return projectList;
  }
}
