package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDateTest
{

  MyDate date = new MyDate();
  MyDate date1 = new MyDate();


  @Test void set()
  {
    date.set(1,3,2020);

    assertEquals(1, date.getDay(), "No correct");
    assertEquals(3, date.getMonth(), "No correct");
    assertEquals(2020, date.getYear(), "No correct");
  }

  @Test void getMonthName()
  {
    date.set(3,7,2012);

    assertEquals("July", date.getMonthName(), "Not correct");
  }

  @Test void stepForward()
  {
    date.set(31,12,2020);
    date.stepForward();

    assertEquals(1, date.getDay(), "No correct");
    assertEquals(1, date.getMonth(), "No correct");
    assertEquals(2021, date.getYear(), "No correct");
  }

  @Test void numberOfDaysInMonth()
  {
    date.set(3,12,2020);

    assertEquals(31, date.numberOfDaysInMonth(), "Not correct");
  }

  @Test void isLeapYear()
  {
    date.set(4,7,2012);

    assertTrue(date.isLeapYear(), "Not a leap year");
  }

  @Test void yearsBetween()
  {
    date.set(3,6,2034);
    date1.set(3,6,2080);

    assertEquals(46, date.yearsBetween(date1), "Not correct");
  }

}