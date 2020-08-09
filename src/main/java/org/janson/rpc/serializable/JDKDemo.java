package org.janson.rpc.serializable;

import java.io.*;

/**
 * @Description: 学生类测试
 * @Author: Janson
 * @Date: 2020/8/9 18:40
 **/
public class JDKDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String home = System.getProperty("user.home");
        String basePath = home + "/Desktop";
        FileOutputStream fos = new FileOutputStream(basePath + "student.dat");
        Student student = new Student();
        student.setNo(100);
        student.setName("TEST_STUDENT");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(basePath + "student.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student deStudent = (Student) ois.readObject();
        ois.close();
        System.out.println(deStudent);

    }


}
