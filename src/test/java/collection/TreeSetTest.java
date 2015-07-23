package collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月20日 上午10:54:20
 */
public class TreeSetTest {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
		set.add("2");
		set.add("1");
		System.out.println(set.add("2")?"此对象不存在":"此对象已经存在");
		set.add("3");
		for (String string : set) {
			System.out.println(string);
		}
	}

}
