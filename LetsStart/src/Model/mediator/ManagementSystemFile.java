package Model.mediator;

import Model.ProjectList;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

/**
 * Handles loading and saving a ProjectList from and to Json file
 *
 * @author Kim
 */
public class ManagementSystemFile implements ManagementSystemPersistence
{
  /**
   * Imported parser that writes the json file
   *
   * @see <a href="https://ict-engineering.dk/javadoc/XmlJsonParser/">Documentation</a>
   */
  private XmlJsonParser parser;

  /**
   * Initializing the parser
   */
  public ManagementSystemFile(){
    parser = new XmlJsonParser();
  }

  /**
   * Saves a ProjectList to a specified file path
   * @param projectList List that is going to be saved
   * @param fileName Path or name of file
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
   * Loads a json file that contains a ProjectList
   * @param fileName Path or name of file
   * @return ProjectList
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
