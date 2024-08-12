package io.eeaters.hiking.portal.entity.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author yjwan
 * @version 1.0
 */
@Data
@Schema(title = "活动信息响应")
public class ActivityResp {

    @Schema(description = "公司名称")
    private String companyName;

    @Schema(description = "起点省份")
    private String sourceProvince;

    @Schema(description = "起点城市")
    private String sourceCity;

    @Schema(description = "起点区县")
    private String sourceDistrict;

    @Schema(description = "目的省份")
    private String destProvince;

    @Schema(description = "目的城市")
    private String destCity;

    @Schema(description = "目的区县")
    private String destDistrict;

    @Schema(description = "目的地址")
    private String destAddress;

    @Schema(description = "活动名称")
    private String activityName;

    @Schema(description = "活动描述")
    private String activityDescription;

    @Schema(description = "封面图片URL")
    private String cover;

    @Schema(description = "活动开始时间")
    private LocalDate activityStartTime;

    @Schema(description = "活动当天天气信息")
    private String weatherInfo;

    @Schema(description = "活动持续时间（天）")
    private Integer duration;
}

    