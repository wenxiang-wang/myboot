package org.myreflex.mydownload;

public class MyTest {
    public static void main(String[] args) {
        String game2 = "http://mirrors.aliyun.com/centos/7.9.2009/isos/x86_64/CentOS-7-x86_64-DVD-2009.iso?spm=a2c6h.25603864.0.0.60196aeawCcNXg";
        //1、连接服务器，获取一个文件，获取文件的长度，在本地创建一个大小跟服务器文件一样大的临时文件
        ThreadDownload threadDownload = new ThreadDownload(game2, "d:\\CentOS-7-x86_64-DVD-2009.iso");
        //设置线程数
        threadDownload.setThreadCount(15);
        //开启断点下载
        //threadDownload.setBpDownload(true);
        //添加进度和网速监听
        threadDownload.addSpeedListener(new SpeedListener() {
            @Override
            public void speed(int s, double progress) {
                String m = String.format("%.2f", (double) s / 1024 / 1024);
                String pro = String.format("%.2f", progress);

                System.out.println(m + "m/s--进度：" + pro + "%");
            }

        });
        //由于ThreadDownload类也是个线程类，可以开启线程
        threadDownload.run();

    }
}
