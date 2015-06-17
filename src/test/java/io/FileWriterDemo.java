package io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月2日 上午10:09:08
 */
public class FileWriterDemo {

	public static void main(String[] args) {
		FileWriter fw = null;
		String filePath = "D://FileWriterDemo.txt";
		try {
			fw = new FileWriter(filePath);
			fw.write("test");
			fw.flush();
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
