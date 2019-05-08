package prove03;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class WeatherForecast {

  // Variables
  CityInfo city;
  List<WeatherForecastItem> list;

  @Override
  public String toString() {
    String toString = "WeatherForecast for " + city.name + ":";
    for (WeatherForecastItem item : list) {
      toString += "\n" + item.toString();
    }
    return toString;
  }
}
