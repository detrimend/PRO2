import java.time.LocalDate;

public class DateInterval
{
  private static final int FIXED_YEAR = 2000;
  private LocalDate startDate;
  private LocalDate endDate;

  public DateInterval(int startDay, int startMonth, int endDay, int endMonth)
  {
    this.startDate = LocalDate.of(FIXED_YEAR, startMonth, startDay);
    this.endDate = LocalDate.of(FIXED_YEAR, endMonth, endDay);
  }

  public LocalDate getStartDate()
  {
    return startDate;
  }

  public LocalDate getEndDate()
  {
    return endDate;
  }

  // Checks if the given date (any year) falls within the interval
  public boolean contains(LocalDate date)
  {
    LocalDate testDate = LocalDate.of(FIXED_YEAR, date.getMonthValue(),
        date.getDayOfMonth());
    if (endDate.isAfter(startDate) || endDate.isEqual(startDate))
    {
      return (testDate.isEqual(startDate) || testDate.isAfter(startDate)) && (
          testDate.isEqual(endDate) || testDate.isBefore(endDate));
    }
    else
    {
      // Interval wraps around the end of the year (e.g., Capricorn)
      return (testDate.isEqual(startDate) || testDate.isAfter(startDate)) || (
          testDate.isEqual(endDate) || testDate.isBefore(endDate));
    }
  }
}