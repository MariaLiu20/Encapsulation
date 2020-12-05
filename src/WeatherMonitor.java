import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * Contains the following methods .
 */
public class WeatherMonitor {
    private IWeather dailyReports;

    public WeatherMonitor(IWeather thisDailyReports) {
        this.dailyReports = thisDailyReports;
    }

    /**
     * produces the average temperature over all days of given month
     * @param month (designated by a number such as 1 for January, 2 for February, etc)
     * @param year
     * @return average temperature over all days of given month
     */
    double averageTempForMonth(int month, int year) {
        return dailyReports.averageTempForMonth(month, year);
    }

    /**
     * produces the total rainfall over all days of given month
     * @param month (designated by a number such as 1 for January, 2 for February, etc)
     * @param year
     * @return total rainfall over all days of given month
     */
    double totalRainfallForMonth(int month, int year) {
       return dailyReports.totalRainfallForMonth(month, year);
    }

    /**
     * stores a daily report for the given date
     * @param date
     * @param readings
     */
    void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
        dailyReports.addDailyReport(date, readings);
    }
}
