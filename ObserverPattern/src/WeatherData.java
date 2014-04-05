import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/7/14
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherData extends Observable{

    private float temperature;
    private float humidity;
    private float pressure;


    public void measurementsChanged(){

        setChanged();
        notifyObservers();

    }

    public void setMeasurements(float temperature, float humidity, float pressure){

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }

    public float getTemperature(){

        return temperature;
    }

    public float getHumidity(){

        return humidity;
    }

    public float getPressure(){

        return pressure;
    }


}
