package Model;

public class Person
{
  private Name name;

  public Person(Name name)
  {
    this.name = name;
  }

  public Person(Name name, char gender)
  {
    this.name = name;
  }

  public Name getName()
  {
    return name;
  }

  public void setName(Name name)
  {
    this.name = name;
  }

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

  @Override public String toString()
  {
    return name.getFullName();
  }
}