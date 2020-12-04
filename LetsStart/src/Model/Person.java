public class Person
{
  private Name name;
  private MyDate birthday;
  private char gender;

  public Person(Name name, MyDate birthday, char gender)
  {
    this.name = name;
    this.birthday = birthday.copy();
    this.gender = gender;
  }

  public Person(Name name, char gender)
  {
    this.name = name;
    this.birthday = new MyDate();
    this.gender = gender;
  }

  public Person(char gender)
  {
    this.name = null;
    this.birthday = new MyDate();
    this.gender = gender;
  }

  public Name getName()
  {
    return name;
  }

  public void setName(Name name)
  {
    this.name = name;
  }

  public int getAge()
  {
    return birthday.yearsBetween(new MyDate());
  }

  public char getGender()
  {
    return gender;
  }

  public void setGender(char gender)
  {
    this.gender = gender;
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

  public MyDate getBirthday(){
    return birthday.copy();
  }

  public String getStatus(){
    if (getAge() < 0){
      return "Error";
    }
    else if (getAge() < 18 && (gender=='m'||gender=='M')){
      return "Boy";
    }
    else if (getAge() < 18){
      return "Girl";
    }
    else if (gender=='m'||gender=='M'){
      return "Man";
    }
    else {
      return "Woman";
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
    return name.equals(person.name) && birthday.equals(person.birthday) && this.gender == person.gender;
  }

  @Override public String toString()
  {
    return name.getFullName() + " " + this.getAge() + " years " + this.getStatus() + " birthday: " + birthday.toStringNames();
  }
}