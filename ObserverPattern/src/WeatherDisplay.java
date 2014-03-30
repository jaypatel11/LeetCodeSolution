import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 1/7/14
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherDisplay implements Observer, DisplayElement{

    Observable observable;
    private float temperature;
    private float pressure;

    public WeatherDisplay(Observable observable){

        this.observable = observable;
        observable.addObserver(this);


    }

    public void update(Observable observable, Object arg){

        if(observable instanceof  WeatherData){

            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.pressure = weatherData.getPressure();
            display();
        }

    }

    public void display(){

        System.out.println("Temp"+this.temperature + "Pressure"+ this.pressure);
    }
}
