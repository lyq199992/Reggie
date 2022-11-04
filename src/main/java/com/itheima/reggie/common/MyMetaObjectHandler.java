package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // Long empId = (Long)request.getSession().getAttribute("employee")
        LocalDateTime nowTime = LocalDateTime.now();

        metaObject.setValue("createTime", nowTime);
        metaObject.setValue("updateTime", nowTime);
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    /**
     * 修改操作自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill: {}", Thread.currentThread().getId());
        LocalDateTime nowTime = LocalDateTime.now();

        metaObject.setValue("updateTime", nowTime);
        metaObject.setValue("updateUser", BaseContext.getCurrentId());

    }
}
