package Model;

public class Name
{
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName){
    setFirstName(firstName);
    setLastName(lastName);
  }

  public Name(String fullName){
    setFirstName(fullName.split(" ")[0]);
    setLastName(fullName.split(" ")[1]);
  }

  public Name(){
    setFirstName("");
    setLastName("");
  }

  private void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  private void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFullName(){
    return firstName + " " +lastName;
  }

  public String getFormalName(){
    return lastName + ", " + firstName;
  }

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

  @Override public String toString(){
    return firstName + " " + lastName;
  }
}