import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 * Represents a daily weather report containing the date and a list of temperature readings
 * and a list of rainfall for that day
 */
public class DailyWeatherReport {
    private GregorianCalendar date;
    private LinkedList<Double> loTemp;
    private LinkedList<Double> loRainfall;

    public DailyWeatherReport(GregorianCalendar thisDate, LinkedList<Double> thisTemperature, LinkedList<Double> thisRainfall) {
        this.date = thisDate;
        this.loTemp = thisTemperature;
        this.loRainfall = thisRainfall;
    }

    /**
     * produces the average temperature
     * @return average temperature
     */
    public double takeTempAvg() {
        double total = 0;
        int count = 0;
        double average;
        for(Double tempReading : loTemp){
            total += tempReading;
            count++;
        }
        if(total != 0){
            average = total / count;
            return average;
        }
        average = 0;
        return average;
    }

    /**
     * produces the total amount of rainfall
     * @return total amount of rainfall
     */
    public double takeRainTotal() {
        double total = 0;
        for(Double rainReading : loRainfall){
            total += rainReading;
        }
        if(total != 0){
            return total;
        }
        return 0;
    }

    /**
     * gets the date of the report
     * @return the date
     */
    public GregorianCalendar getDate(){
        return this.date;
    }
}
