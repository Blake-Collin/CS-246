package prove03;

import com.google.gson.Gson;

public class Main {

  public static void main(String args[]) {
    Gson gson = new Gson();

    String website = "https://api.openweathermap.org/data/2.5/weather?q=Rexburg&apiKey=53788e522a20fc3ec2b53601f2dc02d7";

    WeatherConditions test = new WeatherConditions();

    test = gson.fromJson(website, WeatherConditions.class);

    System.out.println(test.toString());

  }

}
