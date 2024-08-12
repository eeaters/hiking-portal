package io.eeaters.hiking.portal.controller;

import io.eeaters.hiking.portal.entity.vo.resp.ActivityResp;
import io.eeaters.hiking.portal.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yjwan
 * @version 1.0
 */
@RestController
@RequestMapping("/portal/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @GetMapping("all")
    public List<ActivityResp> listActivity(@RequestParam String cityName) {
        return activityService.listAllActivity(cityName);
    }
}

    