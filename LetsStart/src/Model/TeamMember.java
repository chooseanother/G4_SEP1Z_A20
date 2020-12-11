package Model;

public class TeamMember extends Person
{
  private Role role;
  public TeamMember(Name name, String role)
  {
    super(name);
    this.role = new Role(role);
  }

  public Role getRole()
  {
    return role;
  }

  public void assignRole(Role role)
  {
    this.role=role;
  }

  @Override public String toString()
  {
    return super.toString()+" "+role.toString();
  }
}
