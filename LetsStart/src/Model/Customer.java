package Model;

public class Customer extends Person
{
  public Customer(){super();}
  public Customer(Name name){
    super(name);
  }

  public void setName(Name name){
    super.setName(name);
  }

  @Override public boolean equals(Object o){
    return super.equals(o);
  }

  @Override public String toString(){
    return super.toString();
  }
}