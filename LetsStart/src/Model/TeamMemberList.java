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
   *
   * @param index
   * @return
   */
  public TeamMember getTeamMemberIndex (int index)
  {
    return list.get(index);
  }

  /**
   *
   * @param role
   * @return
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
   *
   * @param member
   */
  public void removeTeamMember(TeamMember member)
  {
    list.remove(member);
  }
  public TeamMember getTeamMember(Role role)
  {
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        return member;
    return null;
  }

  /**
   *
   * @param id
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
   *
   * @return
   */
  @Override public String toString()
  {
    String s="";
    for(TeamMember member:list)
      s=s+" "+member.toString()+" // ";
    return s;
  }

}
