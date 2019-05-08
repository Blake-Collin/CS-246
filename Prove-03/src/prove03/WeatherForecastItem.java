package prove03;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {

  // Variables
  String dt_txt;
  List<WeatherData> weather;
  Map<String, Float> wind;

  @SerializedName("main")
  Map<String, Float> measurements;

  @Override
  public String toString() {
    return "WeatherForecastItem{"
        + "Time='"
        + dt_txt
        + '\''
        + ", Temp="
        + measurements.get("temp")
        + ", "
        + weather.toString()
        + ", Wind Speed="
        + wind.get("speed")
        + '}';
  }
}
