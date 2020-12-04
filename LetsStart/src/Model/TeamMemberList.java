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

  public TeamMember getTeamMember(Role role)
  {

  }


}
