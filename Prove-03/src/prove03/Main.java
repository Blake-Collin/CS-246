package prove03;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Contains all test functions for our weather objects conditions, forecast etc.
 *
 * @author Collin Blake
 * @since 5-7-2019
 * @version 1.0.0
 */
public class Main {

  // Variable
  private static Scanner scanner = new Scanner(System.in);
  // Must be provided by coder
  private static String api = "";

  public static void main(String args[]) {
    // Test WeatherConditions
    weatherConditionsTest();

    // Test WeatherForecast
    weatherForecastTest();

    // 5 City Test
    weatherFiveCityTest();
  }

  /** Test for WeatherConditions */
  public static void weatherConditionsTest() {

    // get city Json
    Reader reader = getJsonReader(getUserWC());

    // Create WeatherConditions and deserialize to object
    Gson gson = new Gson();
    WeatherConditions wConditions;
    wConditions = gson.fromJson(reader, WeatherConditions.class);
    System.out.println(wConditions.toString());
  }

  /** Test for WeatherForecast */
  public static void weatherForecastTest() {
    // get city Json via reader
    Reader reader = getJsonReader(getUserWF());

    // Create WeatherConditions and deserialize to object
    Gson gson = new Gson();
    WeatherForecast wForecast;
    wForecast = gson.fromJson(reader, WeatherForecast.class);
    System.out.println(wForecast.toString());
  }

  public static void weatherFiveCityTest() {
    // Cities to hold
    List<WeatherForecast> cities = new ArrayList<>();
    // City names to use
    List<String> stringCities = new ArrayList<>();
    stringCities.addAll(Arrays.asList("rexburg", "bosie", "idaho falls", "pocatello", "blackfoot"));

    // Convert Json data for each into WeatherForecast Objects
    for (String cityName : stringCities) {
      Reader reader = getJsonReader(getUserWF(cityName));
      Gson gson = new Gson();
      WeatherForecast wForecast;
      wForecast = gson.fromJson(reader, WeatherForecast.class);
      cities.add(wForecast);
    }

    // List of WindSpeed & Temp
    Map<String, Float> cityWindSpeeds = new HashMap();
    Map<String, Float> cityTemps = new HashMap();

    // Comparators for WeatherForecastItems
    Comparator<WeatherForecastItem> compareWindSpeed =
        Comparator.comparing((WeatherForecastItem item) -> item.wind.get("speed"));
    Comparator<WeatherForecastItem> compareTemp =
        Comparator.comparing((WeatherForecastItem item) -> item.measurements.get("temp"));

    // Get highest
    for (WeatherForecast item : cities) {
      // Highest Windspeed
      item.list.sort(compareWindSpeed.reversed());
      cityWindSpeeds.put(item.city.name, item.list.get(0).wind.get("speed"));

      // Highest Temp
      item.list.sort(compareTemp.reversed());
      cityTemps.put(item.city.name, item.list.get(0).measurements.get("temp"));
    }

    //LinkedHashMaps for Sorted Maps
    LinkedHashMap<String, Float> sortedCityTemps = new LinkedHashMap<>();
    LinkedHashMap<String, Float> sortedCityWindSpeeds = new LinkedHashMap<>();


    //Sort City temps
    cityTemps.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> sortedCityTemps.put(x.getKey(), x.getValue()));

    //Sort City Wind Speeds
    cityWindSpeeds.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> sortedCityWindSpeeds.put(x.getKey(), x.getValue()));


    System.out.println("\nHighest Wind Speeds:");
    // Output Wind speeds
    for (Entry<String, Float> item : sortedCityWindSpeeds.entrySet()) {
      System.out.println(item.getKey() + " Wind Speed: " + item.getValue());
    }

    System.out.println("\nHighest Temps:");
    // Output Temps
    for (Entry<String, Float> item : sortedCityTemps.entrySet()) {
      System.out.println(item.getKey() + " Temp: " + item.getValue());
    }
  }

  /**
   * Will read a URL to Json and return the reader that contains it
   *
   * @param website URL
   * @return Reader of Json
   */
  public static Reader getJsonReader(String website) {
    // get Json to reader for processing to object
    InputStream is = null;
    try {
      is = new URL(website).openStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
    return reader;
  }

  /** @return website link for city weatherConditions */
  public static String getUserWC() {

    // User Input & API string
    System.out.print("Input City for Weather Conditions: ");
    String userInput = scanner.next();
    String website =
        "https://api.openweathermap.org/data/2.5/weather?q="
            + userInput
            + "&units=imperial&apiKey="
            + api;

    return website;
  }

  /**
   * Override to just use a straight string
   *
   * @return website link for city weatherForecast
   */
  public static String getUserWF(String userInput) {
    String website =
        "https://api.openweathermap.org/data/2.5/forecast?q="
            + userInput
            + "&units=imperial&apiKey="
            + api;
    return website;
  }

  /** @return website link for city weatherForecast */
  public static String getUserWF() {

    // User Input & API string
    System.out.print("Input City for Weather Forecast: ");
    String userInput = scanner.next();
    String website =
        "https://api.openweathermap.org/data/2.5/forecast?q="
            + userInput
            + "&units=imperial&apiKey="
            + api;
    return website;
  }
}
