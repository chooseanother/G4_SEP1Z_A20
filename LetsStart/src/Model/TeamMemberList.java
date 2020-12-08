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

  public TeamMember getTeamMember (String name)
  {
    for(TeamMember teamMember : list)
      if(teamMember.getName().equals(new Name(name)))
      {
        return teamMember;
      }
    return null;
  }

  public int numberOfTeamMembers(){
    return list.size();
  }

  public TeamMember getTeamMember (int index)
  {
    return list.get(index);
  }

  public ArrayList<TeamMember> getTeamMembersByRole(Role role)
  {
    ArrayList<TeamMember> members=new ArrayList<>();
    for(TeamMember member:list)
      if(member.getRole().equals(role))
        members.add(member);
    return members;
  }
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
  public void removeTeamMember(String name){
    list.removeIf(member -> member.getName().equals(new Name(name)));
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
