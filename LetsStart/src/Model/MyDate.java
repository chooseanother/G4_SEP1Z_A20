package Model;
import java.util.GregorianCalendar;

/**
 * Handles storing and manipulation of dates from Gregorian calendar
 *
 * @author Kim
 */
public class MyDate
{
  private int day;
  private int month;
  private int year;

  /**
   * Creates {@link MyDate} object based on local system current date
   */
  public MyDate(){
    this.day = today().day;
    this.month = today().month;
    this.year = today().year;
  }

  /**
   * Creates {@link MyDate} object based on given parameters
   * @param day {@link Integer}
   * @param month {@link Integer}
   * @param year {@link Integer}
   */
  public MyDate(int day, int month, int year)
  {
    this.set(day,month,year);
  }

  /**
   * Creates {@link MyDate} object based on given parameters
   * @param day {@link Integer}
   * @param monthName name of a month as a {@link String}
   * @param year {@link Integer}
   */
  public MyDate(int day, String monthName, int year){
    this(day,convertToMonthNumber(monthName),year);
  }

  /**
   * Checks the given parameters and initializes fields to represent a valid date
   * @param day {@link Integer}
   * @param month {@link Integer}
   * @param year {@link Integer}
   */
  public void set(int day, int month, int year) {
    this.year = Math.abs(year);
    this.month = (month < 1 ? 1 : Math.min(month, 12));
    this.day = (day < 1 ? 1 : Math.min(day, this.numberOfDaysInMonth()));
  }

  /**
   * Gets the day
   * @return {@link Integer}
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Gets the month
   * @return {@link Integer}
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Gets the year
   * @return {@link Integer}
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Checks if year of {@link MyDate} is a leap year
   * @return a {@link Boolean}
   */
  public boolean isLeapYear(){
    return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
  }

  /**
   * Converts month number of a {@link MyDate} into month name
   * @return a {@link String}
   */
  public String getMonthName(){
    String[] months = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    return months[month-1];
  }

  /**
   * Increments {@link MyDate} by one day
   */
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

  /**
   * Increments {@link MyDate} by specified amount of days
   * @param days to increment as an {@link Integer}
   */
  public void stepForward(int days){
    for (int i = 0; i < days; i++){
      stepForward();
    }
  }

  /**
   * Checks if another {@link MyDate} object is before current {@link MyDate}
   * @param date {@link MyDate} object to compare with
   * @return a {@link Boolean}
   */
  public boolean isBefore( MyDate date){
    if(date == null){
      return false;
    }
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

  /**
   * Checks how many years are between given {@link MyDate} and current
   * @param date {@link MyDate}
   * @return amount of years as an {@link Integer}
   */
  public int yearsBetween( MyDate date){
    if(date == null){
      return 0;
    }
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
//  public void monthsBetween(MyDate date){
//    if(date == null){
//      return;
//    }
//    int diff;
//    diff = Math.abs(this.month - date.month);
//  }
//
//  public int daysBetween(MyDate date){
//    MyDate thisDate = this.copy();
//    int count = 0;
//    while (thisDate.isBefore(date)){
//      thisDate.stepForward();
//      count++;
//    }
//    while (thisDate.isBefore(this)){
//      thisDate.stepForward();
//      count++;
//    }
//    return count;
//    //probably implement monthsBetween function.
//    //if same year, return days of monthsBetween + days left in lowest month + days into last month
//    //if different years do something if yearsBetween > 0, do something else if not
//  }

  /**
   * Finds how many days are in current month
   * @return number of days as an {@link Integer}
   */
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

  /**
   * Finds current day of the week
   * @return a {@link String}
   */
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

  /**
   * Creates a {@link MyDate} object based on local system current date
   * @return {@link MyDate}
   */
  public static MyDate today(){
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new MyDate(currentDay,currentMonth,currentYear);
  }

  /**
   * Converts Month name into its number
   * @param monthName {@link String}
   * @return month number as an {@link Integer}
   */
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

  /**
   * Compares another object with current Status object
   *
   * @param obj object you want to compare
   * @return the result of comparing the two objects as boolean
   */
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

  /**
   * Copies current {@link MyDate}
   * @return a copy of current {@link MyDate}
   */
  public MyDate copy(){
    return new MyDate(day,month,year);
  }

  /**
   * Converts a {@link MyDate} object into a simple string
   * @return date in "d/m/y" format
   */
  public String toString(){
    return this.day + "/" + this.month + "/" + year;
  }

  /**
   * Converts a {@link MyDate} object into a verbose string
   * @return date in "Day d'th Month year" format
   */
  public String toStringNames(){
    return this.dayOfWeek() + " " + this.day + (10 < day && day < 14 ? "th " : (day%10 == 1 ? "st " : (day%10 == 2 ? "nd " : (day%10 == 3 ? "rd " : "th ")))) + this.getMonthName() + " " + this.year;
  }
}