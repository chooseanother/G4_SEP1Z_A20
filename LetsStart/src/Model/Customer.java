package Model;

/**
 * Should haven handled customer information, but ended up scrapping
 * the idea of handling more than just customer name so could remove
 * this from the system, since it doesn't add any functionality on
 * top of person class
 * @author Kim
 */
public class Customer extends Person
{
  /**
   * Constructor that takes a Name object
   * @param name Name object
   */
  public Customer(Name name){
    super(name);
  }

  /**
   * Constructor that takes a String object
   * @param name Full name as a string
   */
  public Customer(String name){
    super(name);
  }

  /**
   * This just calls equals method from super
   * @param o Object you want to compare with
   * @return boolean as result of comparison
   */
  @Override public boolean equals(Object o){
    return super.equals(o);
  }

  /**
   * This just calls toString method from super
   * @return String with all information about customer, which is only full name
   */
  @Override public String toString(){
    return super.toString();
  }
}