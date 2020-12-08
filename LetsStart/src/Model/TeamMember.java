package Model;

public class TeamMember extends Person
{
  private String ID;
  private Role role;
  public TeamMember(Name name, String id, String role)
  {
    super(name);
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

  public void assignRole(Role role)
  {
    this.role=role;
  }
  @Override public String toString()
  {
    return super.toString()+" "+ID+" "+role.toString();
  }
}
