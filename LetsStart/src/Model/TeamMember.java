package Model;

public class TeamMember
{
  private String ID;
  private Person person;
  private Role role;
  public TeamMember(Person member, String id, String role)
  {
    person=member;
    ID=id;
    this.role.setRole(role);
  }
  public void setID(String ID)
  {
    this.ID=ID;
  }
  public Role getRole()
  {
    return role;
  }

  public String getID(){
    return ID;
  }
  public String getName(){
    return person.getName().getFullName();
  }
  @Override public String toString()
  {
    return person.toString()+" "+ID+" "+role.toString();
  }
}
