package io.eeaters.hiking.portal.repository;

import io.eeaters.hiking.portal.entity.model.Activity;
import io.eeaters.hiking.portal.enums.ActivityStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author yjwan
 * @version 1.0
 */
public interface ActivityRepository extends JpaRepository<Activity, Long>, JpaSpecificationExecutor<Activity> {

    List<Activity> findAllBySourceProvinceAndStatus(String sourceProvince, ActivityStatusEnum status);

}

    