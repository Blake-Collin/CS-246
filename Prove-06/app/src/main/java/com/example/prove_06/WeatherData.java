package com.example.prove_06;

public class WeatherData {

  // Varaibles
  private int id;
  private String main;
  private String description;
  private String icon;

  public int getId() {
    return id;
  }

  public String getMain() {
    return main;
  }

  public String getDescription() {
    return description;
  }

  public String getIcon() {
    return icon;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  @Override
  public String toString() {
    return "Description='" + description + '\'';
  }
}
