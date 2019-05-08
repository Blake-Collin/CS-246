package prove03;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {

  // Variables
  private int id;
  private String name;

  @SerializedName("main")
  private Map<String, Float> measurements;

  @Override
  public String toString() {
    return "WeatherConditions{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", measurements="
        + measurements
        + '}';
  }
}
