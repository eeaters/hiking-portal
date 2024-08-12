package io.eeaters.hiking.portal.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yjwan
 * @version 1.0
 */

@Data
@Entity(name = "weather_forecast")
public class WeatherForecast {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 城市
     */
    @Column(name = "city",columnDefinition = "VARCHAR(20)")
    private String city;

    /**
     * 日期
     */
    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    /**
     * 星期几
     */
    @Column(name = "week", columnDefinition = "VARCHAR(10)")
    private String week;

    /**
     *  白天天气现象
     */
    @Column(name = "day_weather", columnDefinition = "VARCHAR(50)")
    private String dayWeather;

    /**
     *  晚上天气现象
     */
    @Column(name = "night_weather", columnDefinition = "VARCHAR(50)")
    private String nightWeather;

    /**
     * 白天温度
     */
    @Column(name = "day_temp", columnDefinition = "VARCHAR(10)")
    private String dayTemp;

    /**
     * 晚上温度
     */
    @Column(name = "night_temp", columnDefinition = "VARCHAR(10)")
    private String nightTemp;

    /**
     * 白天风向
     */
    @Column(name = "day_wind", columnDefinition = "VARCHAR(50)")
    private String dayWind;

    /**
     * 晚上风向
     */
    @Column(name = "night_wind", columnDefinition = "VARCHAR(50)")
    private String nightWind;

    /**
     * 白天风力
     */
    @Column(name = "day_power", columnDefinition = "VARCHAR(10)")
    private String dayPower;

    /**
     * 晚上风力
     */
    @Column(name = "night_power", columnDefinition = "VARCHAR(10)")
    private String nightPower;

    /**
     * 报告时间
     */
    @Column(name = "report_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime reportTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime updateTime;



}

