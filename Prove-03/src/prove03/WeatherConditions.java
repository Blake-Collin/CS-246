package prove03;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {

  //Variables
  private int id;
  private String name;
  private Map<String,Float> measurements;

  @Override
  public String toString() {
    return "WeatherConditions{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", measurements=" + measurements +
        '}';
  }
}
