package demo.homework01;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
 */
public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        Class<?> hello = new HelloClassLoader().findClass("Hello");
        Method method = hello.getMethod("hello");
        method.invoke(hello.newInstance());

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get(System.getProperty("user.dir")+"/src/main/java/demo/homework/Hello.xlass");
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }

        return defineClass(name,bytes,0,bytes.length);
    }
}
