package Model;

/**
 * Class that gives a unique id to projects, requirements,
 * tasks and team members. the unique id is just an integer
 * which starts at 1 and counts up. If some object is removed
 * from the system, the id wont be able to be used again.
 * Because of this there is a limit of 2147483647 unique id's
 * this class can hand out
 *
 * @author Kim
 */
public class Id
{
  /**
   * id of type int
   */
  private int id;
  /**
   * field that keeps track of what id to give next
   */
  private static int counter = 1;

  /**
   * Constructor that initializes the id field and increments the counter
   */
  public Id(){
    id = counter;
    counter++;
  }

  /**
   * Returns the id
   * @return returns an int
   */
  public int getId(){
    return id;
  }

  /**
   * Compares another object with current id object
   * @param o object to compare with
   * @return result of comparing the two objects as a boolean
   */
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

  /**
   * Returns id
   * @return id will be returned as a string in the form off "Id: id"
   */
  public String toString(){
    return "Id: " + id;
  }
}
