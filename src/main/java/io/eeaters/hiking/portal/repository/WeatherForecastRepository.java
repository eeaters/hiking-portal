package io.eeaters.hiking.portal.repository;

import io.eeaters.hiking.portal.entity.model.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {

    WeatherForecast findByCityAndDate(String city, LocalDate date);

}
