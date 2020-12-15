package Model.mediator;

import Model.ProjectList;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

/**
 * Handles loading and saving the projectList to a Json file
 *
 * @author Kim
 */
public class ManagementSystemFile implements ManagementSystemPersistence
{
  /**
   * Imported parser that writes the json file
   */
  private XmlJsonParser parser;

  /**
   * Initializing the parser
   */
  public ManagementSystemFile(){
    parser = new XmlJsonParser();
  }

  /**
   *
   * @param projectList
   * @param fileName
   */
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

  /**
   *
   * @param fileName
   * @return
   */
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
