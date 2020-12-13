package Model;

/**
 * Class that will handle a name
 *
 * @author Kim
 */
public class Name
{
  /**
   * First name
   */
  private String firstName;
  /**
   * Last name
   */
  private String lastName;

  /**
   * Constructor that handles a name split in two strings
   *
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName){
    setFirstName(firstName);
    setLastName(lastName);
  }

  /**
   * Constructor that handles a name split in two strings
   *
   * @param fullName a full name
   */
  public Name(String fullName){
    setFirstName(fullName.split(" ")[0]);
    setLastName(fullName.split(" ")[1]);
  }

  /**
   * Sets the first name
   *
   * @param firstName first name
   */
  private void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * Sets the last name
   *
   * @param lastName last name
   */
  private void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  /**
   * Returns the first name
   *
   * @return first name as a string
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Returns the last name
   *
   * @return last name as a string
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Returns the full name
   *
   * @return full name as a string
   */
  public String getFullName(){
    return firstName + " " +lastName;
  }

  /**
   * Returns the name in a formal format
   *
   * @return full name in formal format
   */
  public String getFormalName(){
    return lastName + ", " + firstName;
  }

  /**
   * Compares another object with current name object
   *
   * @param o object you want to compare
   * @return returns the result of comparing the two objects as boolean
   */
  @Override public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false;
    }
    if(!(o instanceof Name)){
      return false;
    }
    Name name = (Name) o;
    return this.getFullName().equals(name.getFullName());
  }

  /**
   * Returns the full name
   *
   * @return returns the full name as a string
   */
  @Override public String toString(){
    return firstName + " " + lastName;
  }
}