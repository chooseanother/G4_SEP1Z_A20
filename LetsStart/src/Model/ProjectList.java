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
  public Project getProject(int index)
  {
    return list.get(index);
  }
  public void removeProject(Project project)
  {
    list.remove(project);
  }
  public void removeProject(int index)
  {
    list.remove(index);
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
