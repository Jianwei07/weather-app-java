package com.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class WeatherResponse {
    @JsonProperty("name") // Maps the "name" field from JSON
    private String name;

    @JsonProperty("main") // Maps the "main" object from JSON
    private Main main;

    @JsonProperty("weather") // Maps the "weather" array from JSON
    private List<Weather> weather;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public static class Main {
        @JsonProperty("temp") // Maps the "temp" field from JSON
        private double temp;

        @JsonProperty("humidity") // Maps the "humidity" field from JSON
        private int humidity;

        // Getters and Setters
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public static class Weather {
        @JsonProperty("description") // Maps the "description" field from JSON
        private String description;

        // Getters and Setters
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
