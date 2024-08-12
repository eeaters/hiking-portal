package io.eeaters.hiking.portal.entity.model;

import io.eeaters.hiking.portal.enums.ActivityStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 活动
 * @author yjwan
 * @version 1.0
 */

@Entity(name = "activity")
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 来源id 。 目前来源全部来自wechat_official_article中
     */
    @Column(name = "source_id")
    private Long sourceId;

    /**
     * 公众号名称
     */
    @Column(name = "wechat_official_name")
    private String wechatOfficialName;


    /**
     * 活动发起省
     */
    @Column(name = "source_province")
    private String sourceProvince;

    /**
     * 活动发起市
     */
    @Column(name = "source_city")
    private String sourceCity;

    /**
     * 活动发起区
     */
    @Column(name = "source_district")
    private String sourceDistrict;

    /**
     * 目的地省
     */
    @Column(name = "dest_province")
    private String destProvince;

    /**
     * 目的地市
     */
    @Column(name = "dest_city")
    private String destCity;

    /**
     * 目的地区
     */
    @Column(name = "dest_district")
    private String destDistrict;

    /**
     * 目的地详细地址
     */
    @Column(name = "dest_address")
    private String destAddress;


    /**
     * 活动名称
     */
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 活动简介
     */
    @Column(name = "activity_description")
    private String activityDescription;

    /**
     * 活动封面
     */
    @Column(name = "cover")
    private String cover;
    /**
     * 活动开始时间
     */
    @Column(name = "activity_start_time")
    private LocalDate activityStartTime;

    /**
     * 活动持续时间
     */
    @Column(name = "duration")
    private Integer duration;
    /**
     * 联系人
     */
    @Column(name = "contract_name")
    private String contractName;


    /**
     * 联系人电话
     */
    @Column(name = "contract_phone")
    private String contractPhone;

    /**
     * 活动状态
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ActivityStatusEnum status;


    /**
     * 创建时间
     */
    @Column(name = "create_time", insertable = false, updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", insertable = false, updatable = false)
    private LocalDateTime updateTime;

}

