/**
 * Copyright (C),2015-2018
 * FileNmae: Aop
 * Author:   Administrator
 * Date:     2018/10/15 15:21
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */
package com.you.bean;

import org.aspectj.lang.JoinPoint;

/**
 * Aop
 * TODO(描述类的作用)
 *
 * @author 陈泽群
 * @date 2018/10/15 15:21
 */
public class Aop {
    public void beforeAop(JoinPoint joinPoint) {
        System.out.println("执行方法前，记录日志");
        System.out.println("执行类名：" + joinPoint.getSignature().getClass().getName());
        System.out.println("执行方法名：" + joinPoint.getSignature().getName());
    }

    public void afterAop() {
        System.out.println("执行方法后，记录日志");
    }
}
