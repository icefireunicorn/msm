package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月20日 下午1:39:13
 */
public class IteratorTest {

	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("轻量级J2EE企业应用实战");
		books.add("Struts2权威指南");
		books.add("基于J2EE的Ajax宝典");
		Iterator iter = books.iterator();
		while (iter.hasNext()) {
			String book = (String) iter.next();
			if (book.equals("Struts2权威指南"))
				iter.remove();
		}
		System.out.println(books);

	}

}
