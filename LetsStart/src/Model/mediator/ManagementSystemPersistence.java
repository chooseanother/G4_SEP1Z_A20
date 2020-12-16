package Model.mediator;

import Model.ProjectList;

/**
 * Persistence to handle saving and loading of {@link ProjectList} into/from a json file
 *
 * @author Kim
 */
public interface ManagementSystemPersistence
{
  /**
   * Saves a {@link ProjectList} to a specified file path
   * @param projectList List that is going to be saved
   * @param fileName Path or name of file
   */
  void save(ProjectList projectList, String fileName);
  /**
   * Loads a json file that contains a {@link ProjectList}
   * @param fileName Path or name of file
   * @return {@link ProjectList}
   */
  ProjectList load(String fileName);
}
