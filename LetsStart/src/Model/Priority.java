package Model;

public class Priority
{
  private int priority;
  private static final String [] PRIORITIES = {"Low", "Medium", "High", "Critical"};

  public Priority(int priority)
  {
    this.priority = priority;
  }

  public void setPriority(int priority)
  {
    this.priority = priority;
  }

  public String getPriorityString()
  {
    return PRIORITIES[priority];
  }

  public int getPriorityNumber(){
    return priority;
  }

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

  @Override public String toString()
  {
    return PRIORITIES[priority];
  }
}

