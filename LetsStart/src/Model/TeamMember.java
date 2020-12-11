package Model;

public class TeamMember extends Person
{
  private Role role;
  private Id id;

  public TeamMember(Name name, String role)
  {
    super(name);
    this.role = new Role(role);
    this.id = new Id();
  }

  public Role getRole()
  {
    return role;
  }

  public int getId(){
    return id.getId();
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
