package demo;

import java.util.Base64;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        new HelloClassLoader().findClass("demo.Hello").newInstance();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64 = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAMTGRlbW8vSGVsbG87AQAIPGNsaW5pdD4BAApTb3VyY2VGaWxlAQAKSGVsbG8uamF2YQwABwAIBwAZDAAaABsBABhIZWxsbyBDbGFzcyBJbml0aWFsaXplZCEHABwMAB0AHgEACmRlbW8vSGVsbG8BABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABQAGAAAAAAACAAEABwAIAAEACQAAAC8AAQABAAAABSq3AAGxAAAAAgAKAAAABgABAAAAAwALAAAADAABAAAABQAMAA0AAAAIAA4ACAABAAkAAAAlAAIAAAAAAAmyAAISA7YABLEAAAABAAoAAAAKAAIAAAAGAAgABwABAA8AAAACABA=";
        byte[] decode = Base64.getDecoder().decode(helloBase64);
        return defineClass(name,decode,0,decode.length);
    }
}
