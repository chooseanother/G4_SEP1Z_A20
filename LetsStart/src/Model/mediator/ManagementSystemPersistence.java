package Model.mediator;

import Model.ProjectList;

public interface ManagementSystemPersistence
{
  void save(ProjectList managementSystem, String fileName);
  ProjectList load(String fileName);
}
