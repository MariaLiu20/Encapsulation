import java.util.GregorianCalendar;
import java.util.LinkedList;

public class ListOfDailyReports implements IWeather {
    LinkedList<DailyWeatherReport> dailyReports;

    public ListOfDailyReports(LinkedList<DailyWeatherReport> thisDailyReports){
        this.dailyReports = thisDailyReports;
    }

    /**
     * produces the average temperature over all days of given month
     * @param month (designated by a number such as 1 for January, 2 for February, etc)
     * @param year
     * @return average temperature over all days of given month
     */
    public double averageTempForMonth(int month, int year) {
        int count = 0;
        double total = 0;
        double average;
        for(DailyWeatherReport report : dailyReports){
            if((report.getDate().get(GregorianCalendar.MONTH) == month) && (report.getDate() .get(GregorianCalendar.YEAR) == year)) {
                total += report.takeTempAvg();
                count++;
            }
        }
        if(total != 0){
            average = total / count;
            return average;
        }
        average = 0;
        return average;
    }

    /**
     * produces the total rainfall over all days of given month
     * @param month (designated by a number such as 1 for January, 2 for February, etc)
     * @param year
     * @return total rainfall over all days of given month
     */
    public double totalRainfallForMonth(int month, int year) {
        double total = 0;
        for(DailyWeatherReport report : dailyReports){
            if((report.getDate().get(GregorianCalendar.MONTH) == month) && report.getDate().get(GregorianCalendar.YEAR) == year){
                total += report.takeRainTotal();
            }
        }
        if(total != 0)
            return total;
        return 0;
    }

    /**
     * stores a daily report for the given date
     * @param date
     * @param readings
     */
    public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings){
        LinkedList<Double> loRainfall = new LinkedList<>();
        LinkedList<Double> loTemp = new LinkedList<>();
        for(Reading read : readings)
            loRainfall.add(read.getRainfall());
        for(Reading read : readings)
            loTemp.add(read.getTemp());
        dailyReports.add(new DailyWeatherReport(date, loTemp, loRainfall));
    }
}
