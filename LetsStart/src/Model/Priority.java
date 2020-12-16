package Model;

/**
 * Handles priority of {@link Requirement}
 *
 * @author Kim
 */
public class Priority
{
  private int priority;
  /**
   * Priorities allowed as a {@link String}[]
   * <p>Priority 0 = "Low"</p>
   */
  public static final String [] PRIORITIES = {"Low", "Medium", "High", "Critical"};

  /**
   * Creates a {@link Priority} based on given parameter
   * @param priority {@link Integer} [0-3] low-high
   */
  public Priority(int priority)
  {
    this.priority = priority;
  }

  /**
   * Sets the priority
   * @param priority {@link Integer} [0-3] low-high
   */
  public void setPriority(int priority)
  {
    this.priority = priority;
  }

  /**
   * Gets the priority as a {@link String}
   * @return priority as a {@link String}
   */
  public String getPriorityString()
  {
    return PRIORITIES[priority];
  }

  /**
   * Gets the priority as an {@link Integer}
   * @return an {@link Integer} [0-3]
   */
  public int getPriorityNumber(){
    return priority;
  }

  /**
   * Compares another object with current Status object
   *
   * @param obj object you want to compare
   * @return the result of comparing the two objects as boolean
   */
  @Override public boolean equals(Object obj)
  {
    if(this == obj){
      return false;
    }
    if(obj == null){
      return false;
    }
    if (!(obj instanceof Priority))
    {
      return false;
    }
    Priority other = (Priority) obj;
    return priority == other.priority;
  }
  /**
   * Returns the priority
   *
   * @return the priority as a string
   */
  @Override public String toString()
  {
    return PRIORITIES[priority];
  }
}

