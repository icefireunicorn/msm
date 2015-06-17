package io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月2日 上午10:09:08
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) {
		FileOutputStream fw = null;
		String filePath = "D://FileWriterDemo.txt";
		try {
			fw = new FileOutputStream(filePath);
			fw.write("test".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
