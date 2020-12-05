import static org.junit.Assert.*;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {

    LinkedList<DailyWeatherReport> dwrList = new LinkedList<>();

    IWeather report = new ListOfDailyReports(dwrList);

    WeatherMonitor weatherMonitor = new WeatherMonitor(report);

    Time time = new Time(10,12);

    LinkedList<Reading> lor = new LinkedList<>();
    LinkedList<Reading> lor1 = new LinkedList<>();
    LinkedList<Reading> lor2 = new LinkedList<>();


    Reading reading = new Reading(time, 40.3, 33.3);
    Reading reading1 = new Reading(time, 22.1, 32.1);
    Reading reading2 = new Reading(time, 53.1, 22);
    Reading reading3 = new Reading(time, 23.1,87.2);

    GregorianCalendar feb3 = new GregorianCalendar(2020, 2,3);
    GregorianCalendar feb20 = new GregorianCalendar(2020, 2, 20);
    GregorianCalendar jan3 = new GregorianCalendar(2020, 1,3);

    public Examples() {

        lor.add(reading);
        lor.add(reading1);
        lor.add(reading2);
        lor.add(reading3);

        lor1.add(reading);
        lor1.add(reading1);

        lor2.add(reading1);
        lor2.add(reading2);
        lor2.add(reading3);

        weatherMonitor.addDailyReport(feb3, lor);
        weatherMonitor.addDailyReport(feb20,lor1);
        weatherMonitor.addDailyReport(jan3, lor2);

    }
    @Test
    public void testForAvgTemp() {
        assertEquals(32.76, weatherMonitor.averageTempForMonth(1,2020),0.01);
    }
    @Test
    public void testForAvgTempLeapYear() {
        assertEquals(32.925, weatherMonitor.averageTempForMonth(2,2020),0.01);
    }

    @Test
    public void testTotalRainfallFeb() {
        assertEquals(240.0, weatherMonitor.totalRainfallForMonth(2,2020), 0.01);
    }
    @Test
    public void testTotalRainfallJan() {
        assertEquals(141.3, weatherMonitor.totalRainfallForMonth(1,2020), 0.01);
    }
    @Test
    public void testTotalRainfallNoData() {
        assertEquals(0, weatherMonitor.totalRainfallForMonth(3,2020), 0.01);
    }

}