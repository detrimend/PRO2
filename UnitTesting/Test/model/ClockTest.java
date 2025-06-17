package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClockTest
{
  private Clock clock;

  @BeforeEach void setUp()
  {
    clock = new Clock(0,0,0);
  }

  private String convert()
  {
    return clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
  }

  @Test void ticZero()
  {
    // no need
  }

  @Test void ticOne()
  {
    clock.tic();
    assertEquals("0:0:1", convert());
  }

  @Test void ticMany()
  {
    for(int i = 0; i < 185; i++)
    {
      clock.tic();
    }
    assertEquals("0:3:5", convert());

    clock.set(0,0,0);
    for(int i = 0; i < 86000; i++)
    {
      clock.tic();
    }
    assertEquals("23:53:20", convert());

    clock.set(0, 0, 0);
    for(int i = 0; i < 86400; i++)
    {
      clock.tic();
    }
    assertEquals("0:0:0", convert());
  }

  @Test void ticBoundary()
  {
    for (int i = 0; i< 59; i++)
    {
      clock.tic();
    }
    assertEquals("0:0:59", convert());

    clock.set(0, 0, 59);
    clock.tic();
    assertEquals("0:1:0", convert());

    clock.set(0, 0, 0);
    for (int i = 0; i< 3599; i++)
    {
      clock.tic();
    }
    assertEquals("0:59:59", convert());
    clock.tic();
    assertEquals("1:0:0", convert());

    clock.set(0, 0, 0);
    for (int i = 0; i< 86399; i++)
    {
      clock.tic();
    }
    assertEquals("23:59:59", convert());
    clock.tic();
    assertEquals("0:0:0", convert());
  }

  @Test void setZero()
  {
    clock.set(0,0,0);
    assertEquals("0:0:0", convert());
  }

  @Test void setOne()
  {
    clock.set(0,0,1);
    assertEquals("0:0:1", convert());
    clock.set(0,1,0);
    assertEquals("0:1:0", convert());
    clock.set(1,0,0);
    assertEquals("1:0:0", convert());
  }

  @Test void setMany()
  {
    clock.set(12,15,20);
    assertEquals("12:15:20", convert());
    clock.set(1,41,9);
    assertEquals("1:41:9", convert());
  }

  @Test void setBoundary()
  {
    clock.set(0,0,59);
    assertEquals("0:0:59", convert());
    clock.set(0,59,0);
    assertEquals("0:59:0", convert());
    clock.set(23,0,0);
    assertEquals("23:0:0", convert());
    clock.set(23,59,59);
    assertEquals("23:59:59", convert());
  }

  @Test void setException()
  {
    assertThrows(IllegalArgumentException.class, () -> clock.set(0,0,-1));
    assertThrows(IllegalArgumentException.class, () -> clock.set(0,0,60));
  }

  @Test void toStringTest()
  {
    clock.set(0, 0, 0);
    assertEquals("00:00:00", clock.toString());

    clock.set(1, 1, 1);
    assertEquals("01:01:01", clock.toString());

    clock.set(23, 59, 59);
    assertEquals("23:59:59", clock.toString());

    clock.set(0, 0, 59);
    assertEquals("00:00:59", clock.toString());

    clock.set(0, 0, 10);
    assertEquals("00:00:10", clock.toString());

    clock.set(0, 10, 0);
    assertEquals("00:10:00", clock.toString());

    clock.set(10, 0, 0);
    assertEquals("10:00:00", clock.toString());

    clock.set(10, 10, 10);
    assertEquals("10:10:10", clock.toString());

    clock.set(0, 0, 11);
    assertEquals("00:00:11", clock.toString());

    clock.set(11, 11, 11);
    assertEquals("11:11:11", clock.toString());
  }
}