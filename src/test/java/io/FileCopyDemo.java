package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月2日 下午1:14:29
 */
public class FileCopyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("d://FileReaderDemo.txt");
			fw = new FileWriter("d://FileWriterDemo.txt");
			char[] buff = new char[1024];
			int temp = 0;
			while((temp = fr.read(buff)) != -1){
				fw.write(new String(buff,0,temp));
				System.out.println(new String(buff,0,temp));
//				fw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 //分别判断是否空指针引用，然后关闭流
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
	}

}
