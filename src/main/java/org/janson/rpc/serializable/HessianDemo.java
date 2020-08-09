package org.janson.rpc.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Description: 学生类测试
 * @Author: Janson
 * @Date: 2020/8/9 18:40
 **/
public class HessianDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        student.setNo(101);
        student.setName("HESSIAN");
        // 把 student对象转化为byte数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(student);
        output.flushBuffer();
        byte[] data = bos.toByteArray();
        output.close();

        // 把刚才序列化出来的bytes数组转化为student对象
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(bis);
        Student deStudent = (Student) input.readObject();
        input.close();
        System.out.println(deStudent);

    }


}
