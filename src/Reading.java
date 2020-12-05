/**
 * Represents a reading containing the time of the reading, the temperature in degrees Fahrenheit, and
 * the amount of rainfall since the last reading
 */
public class Reading {
    Time time;
    private double temperature;
    private double rainfall;

    public Reading(Time thisTime, double thisTemp, double thisRainfall){
        this.temperature = thisTemp;
        this.rainfall = thisRainfall;
        this.time = thisTime;
    }

    /**
     * gets the temperature of the reading in degrees Fahrenheit
     * @return temperature
     */
    public double getTemp(){
        return this.temperature;
    }

    /**
     * gets the amount of rainfall since the last reading
     * @return amount of rainfall
     */
    public double getRainfall(){
        return this.rainfall;
    }
}
