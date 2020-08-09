package org.janson.rpc.serializable;

import java.io.Serializable;

/**
 * @Description: 学生类序列化
 * @Author: Janson
 * @Date: 2020/8/9 18:38
 **/
public class Student implements Serializable {

    // 学号
    private int no;
    // 姓名
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
