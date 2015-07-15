package nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月2日 下午5:06:57
 */
public class FileChannelTest {
	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("d://test//nio/nio.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print(new String( buf.array(),"UTF-8"));
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
