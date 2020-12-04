package Model;

public class Priority
{
  private int priority;
  public static  String [] PRIORITIES = {"Low", "Medium", "High", "Critical"};

  public Priority(int priority)
  {
    this.priority = priority;
    PRIORITIES = null;
  }

  public void setPriority(int priority)
  {
    this.priority = priority;
  }

  public int getPriority()
  {
    return priority;
  }

  @Override public boolean equals(Object obj)
  {
    if (!(obj instanceof Priority))
    {
      return false;
    }
    Priority other = (Priority) obj;
    return priority == other.priority;
  }

  @Override public String toString()
  {
    return String.valueOf(priority);
  }
}

