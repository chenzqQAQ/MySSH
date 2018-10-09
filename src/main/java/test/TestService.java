package test; /**
 * Copyright (C),2015-2018
 * FileNmae: test.TestService
 * Author:   Administrator
 * Date:     2018/10/8 9:32
 * History:
 * <author> <Time> <version> <desc>
 * 陈泽群  时间    版本号  描述
 */

/**
 *test.TestService
 *测试spring
 *@author 陈泽群
 *@date 2018/10/8 9:32
 */
public class TestService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void hello(){
        System.out.println("hello "+getName());
    }
}
