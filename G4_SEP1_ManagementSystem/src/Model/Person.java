package Model;

/**
 * Handles information about a person
 *
 * @author Kim
 */
public class Person
{
  private Name name;

  /**
   * Creates a {@link Person} with given parameters
   * @param name of type {@link Name}
   */
  public Person(Name name)
  {
    this.name = name;
  }

  /**
   * Creates a {@link Person} with given parameters
   * @param name full name as a {@link String}
   */
  public Person(String name)
  {
    this.name = new Name(name);
  }

  /**
   * Creates a {@link Person} with given parameters
   * @param firstName as a {@link String}
   * @param lastName as a {@link String}
   */
  public Person(String firstName, String lastName){name = new Name(firstName,lastName);}

  /**
   * Gets the name of a {@link Person}
   * @return {@link Name}
   */
  public Name getName()
  {
    return name;
  }

  /**
   * Sets the name of a {@link Person}
   * @param name of type {@link Name}
   */
  public void setName(Name name)
  {
    this.name = name;
  }

  /**
   * Compares another object with current Status object
   *
   * @param o object you want to compare
   * @return the result of comparing the two objects as boolean
   */
  @Override public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false;
    }
    if(!(o instanceof Person)){
      return false;
    }
    Person person = (Person)o;
    return name.equals(person.name);
  }

  /**
   * Returns information about a person
   *
   * @return person information as a string
   */
  @Override public String toString()
  {
    return name.getFullName();
  }
}