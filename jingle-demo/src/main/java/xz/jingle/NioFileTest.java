package xz.jingle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Jinhua on 2017/7/12 15:08.
 */
public class NioFileTest {
    public static void main(String[] args) throws IOException {
        copyFileByNIO("G:/temp/xx", "G:/temp/xx.xx");
        System.out.println("finish");
    }
    
    /**
     * 用java NIO api拷贝文件
     */
    public static void copyFileByNIO(String src, String dst) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi = new FileInputStream(new File(src));
        FileOutputStream fo = new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //判断是否读完文件
            int temp = inChannel.read(buffer);
            if (temp == -1) {
                break;
            }
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }
}
