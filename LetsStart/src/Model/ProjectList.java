package Model;

import java.util.ArrayList;

/**
 * Manages an {@link ArrayList} of {@link Project}
 *
 * @author Kim
 */
public class ProjectList
{
  ArrayList<Project> list;

  /**
   * Initializes project list
   */
  public ProjectList()
  {
    list=new ArrayList<>();
  }

  /**
   * Adds a project to the project list
   * @param project {@link Project}
   */
  public void addProject(Project project)
  {
    list.add(project);
  }

  /**
   * Gets a project with given id
   * @param id {@link Integer}
   * @return {@link Project}
   */
  public Project getProject(int id)
  {
    for (Project p : list){
      if (p.getId() == id){
        return p;
      }
    }
    return null;
  }

  /**
   * Gets a project based on given index
   * @param index {@link Integer}
   * @return {@link Project}
   */
  public Project getProjectIndex(int index)
  {
    return list.get(index);
  }

  /**
   * Removes given project from the project list
   * @param project {@link Project} to be removed
   */
  public void removeProject(Project project)
  {
    list.remove(project);
  }

  /**
   * Removes a project that has the given id from the project list
   * @param Id of project to be removed as an {@link Integer}
   */
  public void removeProject(int Id)
  {
    list.removeIf(p -> p.getId() == Id);
  }

  /**
   * Finds the number of projects in the project list
   * @return amount of projects as an {@link Integer}
   */
  public int numberOfProjects()
  {
    return list.size();
  }

  /**
   * Converts all projects in the project list to a string
   * @return a {@link String}
   */
  @Override public String toString()
  {
    StringBuilder s = new StringBuilder("Project List:");
    list.forEach(p -> s.append("\n").append(p));
    return s.toString();
  }
}
