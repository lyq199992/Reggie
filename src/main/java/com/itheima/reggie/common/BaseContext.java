package com.itheima.reggie.common;

import org.springframework.stereotype.Component;

@Component
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal();

    /**
     * 设置 id
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取 id
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
