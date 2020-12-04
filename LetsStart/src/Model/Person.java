package Model;

public abstract class Person
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


  public String getAgeStatus(){
    if (getAge() < 0){
      return "Error";
    }
    else if (getAge() <= 12){
      return "Child";
    }
    else if (getAge() <= 19){
      return "Teenager";
    }
    else if (getAge() <= 65){
      return "Adult";
    }
    else{
      return "Senior citizen";
    }
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