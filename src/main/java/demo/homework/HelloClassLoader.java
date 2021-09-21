package demo.homework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        Class<?> hello = new HelloClassLoader().findClass("Hello");
        Method method = hello.getMethod("hello");
        method.invoke(hello.newInstance());

    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get("/Users/suntao/Desktop/demo/src/main/java/demo/homework/Hello.xlass");
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
