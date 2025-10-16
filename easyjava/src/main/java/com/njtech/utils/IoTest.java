package com.njtech.utils;

import java.io.*;

public class IoTest {
    public static void main(String[] args) throws IOException {
        //文件拷贝
//        FileInputStream is = new FileInputStream("a.txt");
//        FileOutputStream os = new FileOutputStream("b.txt");
//        int b;
//        while ((b=is.read())!=-1) {
//            os.write(b);
//        }
//        //先开的最后关闭
//        os.close();
//        is.close();

        FileInputStream is = new FileInputStream("a.txt");
        FileOutputStream os = new FileOutputStream("b.txt");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while ((len = is.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }

        os.close();
        is.close();
    }

    private void in() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        //读取数据返回一个字节
//        int read = fileInputStream.read();
//        System.out.println(read);
//        int read1 = fileInputStream.read();
//        System.out.println(read1);
        //采用循环读取
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.println((char) b);
        }
        fileInputStream.close();
    }


    private void out() throws IOException {
        //创建流对象(当文件不存在时会自动创建)
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt", true);//开启追加模式
        /** 创建流对象的第二种方法
         File file = new File("a.txt");
         FileOutputStream fileOutputStream = new FileOutputStream(file);
         */
        //fileOutputStream.write("97".getBytes());
        for (int i = 0; i < 100; i++) {
            fileOutputStream.write(String.valueOf(i).getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }
}
