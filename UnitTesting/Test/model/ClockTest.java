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
    assertThrows(IllegalArgumentException.class, () -> clock.set(0,0,-1));
    clock.set(0,0,59);
    assertEquals("0:0:59", convert());
    assertThrows(IllegalArgumentException.class, () -> clock.set(0,0,60));

  }
}