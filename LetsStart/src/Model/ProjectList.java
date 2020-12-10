package Model;

import java.util.ArrayList;

public class ProjectList
{
  ArrayList<Project> list;
  public ProjectList()
  {
    list=new ArrayList<>();
  }
  public void addProject(Project project)
  {
    list.add(project);
  }
  public Project getProject(int id)
  {
    for (Project p : list){
      if (p.getId() == id){
        return p;
      }
    }
    return null;
  }
  public Project getProjectIndex(int index)
  {
    return list.get(index);
  }
  public void removeProject(Project project)
  {
    list.remove(project);
  }
  public void removeProject(int Id)
  {
    list.removeIf(p -> p.getId() == Id);
  }
  public int numberOfProjects()
  {
    return list.size();
  }
  @Override public String toString()
  {
    String s="";
    for(Project project:list)
      s+=project.toString();
    return s;
  }
}
