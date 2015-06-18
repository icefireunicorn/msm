package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月2日 下午12:41:26
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("d://FileReaderDemo.txt");
			try {
//				int temp = 0;
//				while((temp =fr.read()) != -1){
//					System.out.println((char)temp);
//				}
				char[] buff = new char[10];
				int temp = 0;
				while((temp=fr.read(buff)) != -1){
					System.out.println(temp);
					System.out.println(new String(buff,0,temp));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

	}

}
