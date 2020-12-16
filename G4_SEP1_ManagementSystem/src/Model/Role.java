package Model;

/**
 * Handles role information of {@link TeamMember}
 * @author Kim
 */
public class Role
{
  /**
   * public field that makes sure assigned roles are allowed
   */
  public static final String PROJECT_CREATOR = "Project Creator";
  /**
   * public field that makes sure assigned roles are allowed
   */
  public static final String PRODUCT_OWNER = "Product Owner";
  /**
   * public field that makes sure assigned roles are allowed
   */
  public static final String SCRUM_MASTER = "Scrum Master";
  /**
   * public field that makes sure assigned roles are allowed
   */
  public static final String TEAM_MEMBER = "Team Member";
  private String role;

  /**
   * Default constructor
   * <p>Initializes role as an empty {@link String}</p>
   */
  public Role()
  {
    role="";
  }

  /**
   * <p>Initializes role to specified {@link String}</p>
   * @param role role of a team member. Use any of the public fields from {@link Role} class.
   */
  public Role(String role)
  {
    this.role=role;
  }

  /**
   * <p>Sets role to specified {@link String}</p>
   * @param role role of a team member. Use any of the public fields from {@link Role} class.
   */
  public void setRole(String role){
    this.role=role;
  }

  /**
   * Returns the role
   * @return role as a {@link String}
   */
  public String getRole(){
    return role;
  }

  /**
   * Compares another object with current Status object
   *
   * @param o object you want to compare
   * @return the result of comparing the two objects as boolean
   */
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

  /**
   * Returns the role
   *
   * @return the role as a string
   */
  @Override public String toString()
  {
    return role;
  }
}
