package Model;

import java.util.ArrayList;

/**
 * Class that handles a list of team members
 * @author Kim
 */
public class TeamMemberList
{
  /**
   * ArrayList for storing team members
   */
  private ArrayList<TeamMember> list;

  /**
   * Initializes the ArrayList
   */
  public TeamMemberList()
  {
    list = new ArrayList<>();
  }

  /**
   * Adds a TeamMember object to the ArrayList
   * @param teamMember TeamMember that is goign to be added
   */
  public void addTeamMember(TeamMember teamMember)
  {
    list.add(teamMember);
  }

  /**
   * Gets a TeamMember from the ArrayList depending on id
   * @param memberId id of TeamMember you want
   * @return TeamMember object
   */
  public TeamMember getTeamMember (int memberId)
  {
    for(TeamMember teamMember : list)
      if(teamMember.getId() == memberId)
      {
        return teamMember;
      }
    return null;
  }

  /**
   * Returns number of TeamMembers in ArrayList
   * @return amount as int
   */
  public int numberOfTeamMembers(){
    return list.size();
  }

  /**
   * Returns TeamMember of specified index
   * @param index of TeamMember object user wants returned
   * @return TeamMember object
   */
  public TeamMember getTeamMemberIndex (int index)
  {
    return list.get(index);
  }

  /**
   * Finds all {@link TeamMember}s with specified {@link Role}
   * @param role object containing {@link Role} information
   * @return {@link ArrayList} containing all {@link TeamMember}s with specified {@link Role}
   */
  public ArrayList<TeamMember> getTeamMembersByRole(Role role)
  {
    ArrayList<TeamMember> members=new ArrayList<>();
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        members.add(member);
    return members;
  }

  /**
   * Removes specified {@link TeamMember} object from the list
   * @param member team member to be removed
   */
  public void removeTeamMember(TeamMember member)
  {
    list.remove(member);
  }

  /**
   * Finds a {@link TeamMember} with specified {@link Role}
   * @param role object containing {@link Role} information
   * @return first {@link TeamMember} with specified {@link Role}
   */
  public TeamMember getTeamMember(Role role)
  {
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        return member;
    return null;
  }

  /**
   * Removes {@link TeamMember} from the list containing specified id
   * @param id of team member to be removed
   */
  public void removeTeamMember(int id)
  {
     for (TeamMember tm : list){
       if (tm.getId() == id){
         list.remove(tm);
         break;
       }
     }
  }

  /**
   * Returns all team members as a string
   * @return String containing information off all team members in the list
   */
  @Override public String toString()
  {
    StringBuilder s = new StringBuilder("Team members: ");
    list.forEach(t -> s.append("\n").append(t));
    return s.toString();
  }

}
