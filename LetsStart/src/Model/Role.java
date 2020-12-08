package Model;

public class Role
{
  public static final String PROJECT_CREATOR = "Project Creator";
  public static final String PRODUCT_OWNER = "Product Owner";
  public static final String SCRUM_MASTER = "Scrum Master";
  public static final String TEAM_MEMBER = "Team Member";
  private String role;

  public Role()
  {
    role="";
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

  public boolean equals(Object o){
    if (this == o){
      return false;
    }
    if(o==null){
      return false;
    }
    if(!(o instanceof Role)){
      return false;
    }
    Role comp = (Role) o;
    return role.equalsIgnoreCase(comp.getRole());
  }

  @Override public String toString()
  {
    return role;
  }
}
