package com.example.prove_06;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WeatherMain {

  public static final String api = "53788e522a20fc3ec2b53601f2dc02d7";

  public static WeatherForecast getForecast(String town) {
    Reader reader = getJsonReader(getUserWF(town));

    // Create WeatherConditions and deserialize to object
    Gson gson = new Gson();
    WeatherForecast wForecast;
    wForecast = gson.fromJson(reader, WeatherForecast.class);
    return wForecast;
  }

  public static WeatherConditions getConditions(String town) {
    // get city Json
    Reader reader = getJsonReader(getUserWC(town));

    // Create WeatherConditions and deserialize to object
    Gson gson = new Gson();
    WeatherConditions wConditions;
    wConditions = gson.fromJson(reader, WeatherConditions.class);
    return wConditions;
  }

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

  public static String getUserWC(String town) {
    String website =
        "https://api.openweathermap.org/data/2.5/weather?q="
            + town
            + "&units=imperial&apiKey="
            + api;
    return website;
  }

  public static String getUserWF(String town) {
    String website =
        "https://api.openweathermap.org/data/2.5/forecast?q="
            + town
            + "&units=imperial&apiKey="
            + api;
    return website;
  }
}
