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

  public Requirement getRequirementId(int ID)
  {
    for(Requirement requirement:list)
      if(requirement.getId()==(ID))
      {
        return requirement;
      }
    return null;
  }
  public Requirement getRequirementIndex(int index)
  {
    return list.get(index);
  }

  public int getNumberOfRequirements()
  {
    return list.size();
  }

  public ArrayList<Requirement> getRequirementByStatus(String status){
    ArrayList<Requirement> reqByStatus = new ArrayList<>();
    for (Requirement req : list){
      if (req.getStatus().equals(new Status(true,status))){
        reqByStatus.add(req);
      }
    }
    return reqByStatus;
  }

  public void removeRequirement(int id)
  {
    list.removeIf(req -> req.getId() == id);
  }

  public void removeRequirement(Requirement requirement)
  {
    list.remove(requirement);
  }

  @Override public String toString()
  {
    StringBuilder s= new StringBuilder();
    for(Requirement requirement:list)
    {
      s.append(requirement.toString());
    }
    return s.toString();
  }


}
