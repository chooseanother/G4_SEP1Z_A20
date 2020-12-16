package Model;

import java.util.ArrayList;

/**
 * Handles an {@link ArrayList} of {@link Requirement}
 *
 * @author Kim
 */
public class RequirementList
{
  private ArrayList<Requirement> list;

  /**
   * Initializes an array list
   */
  public RequirementList()
  {
    list = new ArrayList<>();
  }

  /**
   * Adds specified requirement to the list
   * @param requirement as an {@link Requirement}
   */
  public void addRequirement(Requirement requirement)
  {
    list.add(requirement);
  }

  /**
   * Returns a requirement with specified id
   * @param ID as an {@link Integer}
   * @return a {@link Requirement} <p>If not found it will return null</p>
   */
  public Requirement getRequirementId(int ID)
  {
    for(Requirement requirement:list)
      if(requirement.getId()==(ID))
      {
        return requirement;
      }
    return null;
  }

  /**
   * Returns a requirement at specified index in the list
   *
   * @param index as an {@link Integer}
   * @return a {@link Requirement}
   */
  public Requirement getRequirementIndex(int index)
  {
    return list.get(index);
  }

  /**
   * Returns number of requirements currently in the list
   * @return amount as an {@link Integer}
   */
  public int getNumberOfRequirements()
  {
    return list.size();
  }

  /**
   * Gets all requirements based on status of linked parameter
   * @param status as a {@link String}
   * @return an {@link ArrayList} of type {@link Requirement}
   */
  public ArrayList<Requirement> getRequirementByStatus(String status){
    ArrayList<Requirement> reqByStatus = new ArrayList<>();
    for (Requirement req : list){
      if (req.getStatus().equals(new Status(true,status))){
        reqByStatus.add(req);
      }
    }
    return reqByStatus;
  }

  /**
   * Removes a requirement with specified id from the list
   * @param id as an {@link Integer}
   */
  public void removeRequirement(int id)
  {
    list.removeIf(req -> req.getId() == id);
  }

  /**
   * Removes specified requirement from the list
   * @param requirement as an {@link Requirement}
   */
  public void removeRequirement(Requirement requirement)
  {
    list.remove(requirement);
  }

  /**
   * Creates a string with information from all requirements currently in a list
   * @return a {@link Requirement}
   */
  @Override public String toString()
  {
    StringBuilder s= new StringBuilder("Requirement list: ");
    list.forEach(r -> s.append("\n").append(r));
    return s.toString();
  }
}
