package Model;

/**
 * This class extends Person and will handle information regarding team members
 * @author Kim
 */
public class TeamMember extends Person
{
  /**
   * Field that stores a team members role
   */
  private Role role;
  /**
   * Field that stores a team members id
   */
  private Id id;

  /**
   * Constructor that takes a Name object and role as a string
   * Id is initialized automatically,
   * please see the {@link Id} class for more information
   * calls super constructor see {@link Person}
   * @param name Object containing name information
   * @param role
   */
  public TeamMember(Name name, String role)
  {
    super(name);
    this.role = new Role(role);
    this.id = new Id();
  }

  /**
   * Returns the role of a team member
   * @return Returns a Role object
   */
  public Role getRole()
  {
    return role;
  }

  /**
   * Returns the id of a team member
   * @return Returns id as an integer
   */
  public int getId(){
    return id.getId();
  }

  /**
   * Change the role of a team member
   * @param role Role object with new role information
   */
  public void assignRole(Role role)
  {
    this.role=role;
  }

  /**
   * Converts all team member information into a string
   * Calls super string method {@link Person}
   * @return a String with all information about team member
   */
  @Override public String toString()
  {
    return super.toString()+" "+role.toString();
  }
}
