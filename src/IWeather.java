import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Interface class that has the following methods.
 */
public interface IWeather {
    double averageTempForMonth(int month, int year);
    double totalRainfallForMonth(int month, int year);
    void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings);
}
