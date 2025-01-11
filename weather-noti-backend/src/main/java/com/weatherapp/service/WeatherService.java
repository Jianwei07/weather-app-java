package com.weatherapp.service;

import com.weatherapp.model.ForecastItem;
import com.weatherapp.model.ForecastResponse;
import com.weatherapp.model.WeatherResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient webClient;

    @Value("${spring.weather.open-weather-api-key}")
    private String apiKey;

    public WeatherService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public WeatherResponse getWeatherAndForecast(String city) {
        // Fetch current weather
        WeatherResponse currentWeather = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

        // Fetch 5-day/3-hour forecast
        // ForecastResponse forecastResponse = webClient.get()
        // .uri(uriBuilder -> uriBuilder
        // .path("/forecast")
        // .queryParam("q", city)
        // .queryParam("appid", apiKey)
        // .queryParam("units", "metric")
        // .build())
        // .retrieve()
        // .bodyToMono(ForecastResponse.class)
        // .block();

        // Combine the data
        // return new WeatherResponse(
        // currentWeather.getName(),
        // currentWeather.getMain().getTemp(),
        // currentWeather.getWeather().get(0).getDescription(),
        // currentWeather.getMain().getHumidity(),
        // forecastResponse.getList());
        // }
    }
}
