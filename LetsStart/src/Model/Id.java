package Model;

public class Id
{
  private int id;
  private static int counter = 1;

  public Id(){
    id = counter;
    counter++;
  }

  public int getId(){
    return id;
  }

  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if(o == null){
      return false;
    }
    if(!(o instanceof Id)){
      return false;
    }
    Id comp = (Id)o;
    return id == comp.getId();
  }

  public String toString(){
    return "Id: " + id;
  }
}
