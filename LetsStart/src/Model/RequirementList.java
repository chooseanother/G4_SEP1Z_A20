package Model;

import java.util.ArrayList;

public class RequirementList
{
  private ArrayList<Requirement> list;
  public RequirementList()
  {
    list = new ArrayList<>();
  }
  public void addRequirement(Requirement requirement)
  {
    list.add(requirement);
  }
  public void removeRequirement(int index)
  {
    list.remove(index);
  }
  public void removeRequirement(Requirement requirement)
  {
    list.remove(requirement);
  }
  public Requirement getRequirement(String ID)
  {
    for(Requirement requirement:list)
      if(requirement.getReqID().equals(ID))
      {
        return requirement;
      }
    return null;
  }
  public Requirement getRequirement(int index)
  {
    return list.get(index);
  }
  public int getNumberOfRequirements()
  {
    return list.size();
  }
  @Override public String toString()
  {
    String s="";
    for(Requirement requirement:list)
    {
      s+=requirement.toString();
    }
    return s;
  }


}
