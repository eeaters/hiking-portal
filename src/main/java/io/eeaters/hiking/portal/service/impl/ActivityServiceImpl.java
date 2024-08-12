package io.eeaters.hiking.portal.service.impl;

import io.eeaters.hiking.portal.entity.model.WeatherForecast;
import io.eeaters.hiking.portal.entity.vo.resp.ActivityResp;
import io.eeaters.hiking.portal.enums.ActivityStatusEnum;
import io.eeaters.hiking.portal.repository.ActivityRepository;
import io.eeaters.hiking.portal.repository.WeatherForecastRepository;
import io.eeaters.hiking.portal.service.ActivityService;
import io.eeaters.hiking.portal.support.HikingHandlerAdapter;
import io.eeaters.hiking.portal.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/**
 * @author yjwan
 * @version 1.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    WeatherForecastRepository weatherForecastRepository;


    //判断最近的活动,然后填充天气信息
    HikingHandlerAdapter<ActivityResp> weatherFullAdapter = resp -> {
        LocalDate activityStartTime = Optional.ofNullable(resp)
                .map(ActivityResp::getActivityStartTime)
                .orElse(null);
        if (activityStartTime == null) {
            return false;
        }
        LocalDate now = LocalDate.now();
        if (activityStartTime.isBefore(now)) {
            return false;
        }
        LocalDate afterFiveDay = now.plusDays(5);
        if (activityStartTime.isAfter(afterFiveDay)) {
            return false;
        }
        return true;
    };

    @Override
    public List<ActivityResp> listAllActivity(String cityName) {
        List<ActivityResp> respList = activityRepository.findAllBySourceProvinceAndStatus(cityName, ActivityStatusEnum.ONLINE)
                .stream()
                .map(activity -> ConvertUtils.toEntity(activity, ActivityResp.class))
                .sorted(Comparator.comparing(ActivityResp::getActivityStartTime))
                .toList();
        Map<String, String> weatherCacheMap = new HashMap<>();
        for (ActivityResp activityResp : respList) {
            weatherFullAdapter.handle(activityResp, _ -> handlerWeather(activityResp, weatherCacheMap));
        }
        return respList;
    }

    private void handlerWeather(ActivityResp activityResp, Map<String, String> weatherMap) {
        String destDistrict = activityResp.getActivityStartTime() + activityResp.getDestDistrict();

        String weatherInfo = weatherMap.computeIfAbsent(destDistrict, _ -> {
            WeatherForecast cityAndDate = weatherForecastRepository.findByCityAndDate(activityResp.getDestDistrict(), activityResp.getActivityStartTime());
            if(cityAndDate == null) {
                return null;
            }
            return "白天天气" + cityAndDate.getDayWeather() + ", 温度: " + cityAndDate.getNightTemp() + " - " + cityAndDate.getDayTemp();
        });
        activityResp.setWeatherInfo(weatherInfo);
    }

}

    