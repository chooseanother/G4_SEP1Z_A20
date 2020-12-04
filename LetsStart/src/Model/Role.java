package Model;

public class Role
{
  public static String[] POSSIBLE_ROLES = {"Project Creator", "Product Owner", "Team Member", "Scrum Master"};
  private String role;
  public Role()
  {
    role=POSSIBLE_ROLES[2];
  }
  public Role(String role)
  {
    this.role=role;
  }
  public void setRole(String role){
    this.role=role;
  }
  public String getRole(){
    return role;
  }

}
