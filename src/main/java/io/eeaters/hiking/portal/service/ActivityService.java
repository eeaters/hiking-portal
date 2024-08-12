package io.eeaters.hiking.portal.service;


import io.eeaters.hiking.portal.entity.vo.resp.ActivityResp;

import java.util.List;

/**
 * 活动服务类
 * @author yjwan
 * @version 1.0
 */
public interface ActivityService {


    List<ActivityResp> listAllActivity(String cityName);
}

    