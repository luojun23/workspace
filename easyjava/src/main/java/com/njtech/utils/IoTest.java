package com.njtech.utils;

import java.io.*;

public class IoTest {
    public static void main(String[] args) throws IOException {
        //加密
        encryptionAndReduction(new File("D:\\\\HTML\\\\files\\\\1.jpg"),new File("D:\\HTML\\files\\secret.jpg"));
        //解密
        encryptionAndReduction(new File("D:\\HTML\\files\\secret.jpg"),new File("D:\\HTML\\files\\2.jpg"));
    }


    public static void encryptionAndReduction(File src, File dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b ^ 2);
        }
        //4.释放资源
        fos.close();
        fis.close();
    }

    /**
     * 拷贝文件夹
     * @throws IOException
     */
    private void copyDir(File src,File dest) throws IOException {
        if (!dest.exists()){
            dest.mkdirs();
        }
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()){
                FileInputStream is = new FileInputStream(file);
                FileOutputStream os = new FileOutputStream(new File(dest,file.getName()));

                int len;
                byte[] bytes = new byte[1024 * 1024 * 5];
                while ((len = is.read(bytes)) != -1) {
                    os.write(bytes,0,len);
                }

                os.close();
                is.close();
            }else {
                copyDir(file,new File(dest,file.getName()));
            }
        }
    }

    private void file() throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter("b.txt");
            fw.write(97);
            fw.write('a');
            fw.write('b');
            fw.write(30000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }

    private void copy() throws IOException {
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
