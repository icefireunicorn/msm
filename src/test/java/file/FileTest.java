package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTest {

	public static void main(String[] args) {
		String imageUrl = "http://www.kadang.com/imgs/e/2/admin/131209/1439/2i_79aboAeIazKgyi9WSI-.jpg";
		saveUrlAsFile(imageUrl);

	}
	
	private static String getFilePath(String imgSrc){
		String reg = "(http://[\\w\\.]+)?/+(\\w+)/(.*)";
		Matcher m = Pattern.compile(reg).matcher(imgSrc);
		String filePath = m.replaceAll("/$2/$3");
		return "D:/store" + filePath;
	}

	public static boolean saveUrlAsFile(String imageUrl) {
		String fileName = imageUrl.substring(imageUrl.lastIndexOf("/"));
		String filePath = getFilePath(imageUrl.substring(0,imageUrl.lastIndexOf("/")));
		makeDir(filePath);
		// 此方法只能用户HTTP协议
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath + fileName));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public static synchronized void makeDir(String dir) {
		File dirFile = new File(dir);
		if (!dirFile.exists() && !dirFile.mkdirs()) {
			try {
				Thread.sleep(20);
				if (!dirFile.exists() && !dirFile.mkdirs()) {
					throw new RuntimeException("创建目录" + dir + "失败");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
