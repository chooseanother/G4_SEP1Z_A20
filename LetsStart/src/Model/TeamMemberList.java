package Model;

import java.util.ArrayList;

public class TeamMemberList
{
  private ArrayList<TeamMember> list;

  public TeamMemberList()
  {
    list = new ArrayList<>();
  }

  public void addTeamMember(TeamMember teamMember)
  {
    list.add(teamMember);
  }

  public TeamMember getTeamMember (String ID)
  {
    for(TeamMember teamMember : list)
      if(teamMember.getID().equals(ID))
      {
        return teamMember;
      }
    return null;
  }

  public ArrayList<TeamMember> getTeamMembersByRole(Role role)
  {
    ArrayList<TeamMember> members=new ArrayList<>();
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        members.add(member);
    return members;
  }
  public TeamMember getTeamMember(Role role)
  {
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        return member;
    return null;
  }
  public void removeTeamMember(String ID){
    for(TeamMember member:list)
      if(member.getID().equals(ID))
        list.remove(member);
  }
  public void removeTeamMember(int index)
  {
     list.remove(index);
  }
  @Override public String toString()
  {
    String s="";
    for(TeamMember member:list)
      s=s+" "+member.toString()+" // ";
    return s;
  }

}
