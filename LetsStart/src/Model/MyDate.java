package Model;
import java.util.GregorianCalendar;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  public MyDate(){
    this.day = today().day;
    this.month = today().month;
    this.year = today().year;
  }

  public MyDate(int day, int month, int year)
  {
    this.set(day,month,year);
  }

  public MyDate(int day, String monthName, int year){
    this(day,convertToMonthNumber(monthName),year);
  }

  public void set(int day, int month, int year) {
    this.year = Math.abs(year);
    this.month = (month < 1 ? 1 : Math.min(month, 12));
    this.day = (day < 1 ? 1 : Math.min(day, this.numberOfDaysInMonth()));
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public boolean isLeapYear(){
    return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
  }

  public String getMonthName(){
    String[] months = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    return months[month-1];
  }

  public void stepForward(){
    if (((day + 1) > this.numberOfDaysInMonth()) && ((month + 1) > 12)){
      this.day = 1;
      this.month = 1;
      year++;
    }
    else if ((day + 1)> this.numberOfDaysInMonth()){
      this.day = 1;
      month++;
    }
    else{
      day++;
    }
  }

  public void stepForward(int days){
    for (int i = 0; i < days; i++){
      stepForward();
    }
  }

  public boolean isBefore( MyDate date){
    if (this.year < date.year){
      return true;
    }
    else if ((this.year == date.year) && (this.month < date.month)){
      return true;
    }
    else
    {
      return (this.year == date.year) && (this.month == date.month)
          && (this.day < date.day);
    }
  }

  public int yearsBetween( MyDate date){
    int diff;
    diff = Math.abs(this.year - date.year);
    if ((diff != 0) &&
        ((date.isBefore(this) && (this.month > date.month)) ||
            (this.isBefore(date) && (this.month < date.month))) ||
        (date.month == this.month) && (this.day < date.day)){
      return diff -1;
    }
    else{
      return diff;
    }
  }

  //NOT IMPLEMENTED
  public void monthsBetween(MyDate date){
    int diff;
    diff = Math.abs(this.month - date.month);
  }

  public int daysBetween(MyDate date){
    MyDate thisDate = this.copy();
    int count = 0;
    while (thisDate.isBefore(date)){
      thisDate.stepForward();
      count++;
    }
    while (thisDate.isBefore(this)){
      thisDate.stepForward();
      count++;
    }
    return count;
    //probably implement monthsBetween function.
    //if same year, return days of monthsBetween + days left in lowest month + days into last month
    //if different years do something if yearsBetween > 0, do something else if not
  }

  public int numberOfDaysInMonth(){
    if (month == 2 && this.isLeapYear()){
      return 29;
    }
    else if (month == 2){
      return 28;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11){
      return 30;
    }
    else
      return 31;

  }

  public String dayOfWeek(){
    int q = day;
    int m = month;
    if (month < 3){
      m += 12;
    }
    int k = year % 100;
    if (month < 3){
      k = (year-1)%100;
    }
    int j = year / 100;
    if (month < 3){
      j = (year-1) / 100;
    }
    int h;
    String[] days = {"Saturday", "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday"};
    h = (q+((13*(m+1))/5)+k+(k/4)+(j/4)+(5*j))%7;

    return days[h];
  }

  public static MyDate today(){
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new MyDate(currentDay,currentMonth,currentYear);
  }

  public static int convertToMonthNumber(String monthName){
    switch (monthName){
      case "february": case "February": return 2;
      case "march": case "March": return 3;
      case "april": case "April": return 4;
      case "may": case "May": return 5;
      case "june": case "June": return 6;
      case "july": case "July": return 7;
      case "august": case "August": return 8;
      case "september": case "September": return 9;
      case "october": case "October": return 10;
      case "november": case "November": return 11;
      case "december": case "December": return 12;
      default: return 1;
    }
  }

  public boolean equals(Object obj){
    if(obj==this){
      return true;
    }
    if (obj == null){
      return false;
    }
    if (!(obj instanceof MyDate)){
      return false;
    }
    MyDate comp = (MyDate) obj;
    return this.day == comp.day && this.month == comp.month && this.year == comp.year;
  }

  public MyDate copy(){
    return new MyDate(day,month,year);
  }

  public String toString(){
    return this.day + "/" + this.month + "/" + year;
  }

  public String toStringNames(){
    return this.dayOfWeek() + " " + this.day + (10 < day && day < 14 ? "th " : (day%10 == 1 ? "st " : (day%10 == 2 ? "nd " : (day%10 == 3 ? "rd " : "th ")))) + this.getMonthName() + " " + this.year;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }
}