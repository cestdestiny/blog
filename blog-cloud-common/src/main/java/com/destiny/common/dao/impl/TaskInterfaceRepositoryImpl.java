package com.destiny.common.dao.impl;

import com.destiny.common.constant.DateTimeFormatConstant;
import com.destiny.common.dao.BaseHibernate;
import com.destiny.common.dao.custom.TaskInterfaceRepositoryCustom;
import com.destiny.common.domain.pojo.TaskInterface;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskInterfaceRepositoryImpl extends BaseHibernate<TaskInterface> implements TaskInterfaceRepositoryCustom {
    @Override
    public List<TaskInterface> findBySubTaskType(Integer limitNum, String subTaskCode) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> condition = Maps.newHashMap();
        sql.append("select * from d_task_interface where 1 = 1 ");
        if (subTaskCode != null) {
            sql.append(" and sub_task_type = :subTaskCode");
            condition.put("subTaskCode", subTaskCode);
        }
        sql.append(" and next_execute_time between :startTime and :endTime");
        sql.append(" and execution_status = '1'");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = now.minusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeFormatConstant.DATE_TIME);
        String startTime = formatter.format(startDateTime);
        String endTime = formatter.format(now);
        condition.put("startTime", startTime);
        condition.put("endTime", endTime);
        if (limitNum != null) {
            sql.append(" limit :limitNum");
            condition.put("limitNum", limitNum);
        }
        return this.findAllObjectByCondition(sql.toString(), condition);
    }

}
