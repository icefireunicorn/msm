package collection;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月20日 上午10:54:20
 */
public class LinkedHashSetTest {

	public static void main(String[] args) {
		Set<String> hashSet = new LinkedHashSet<String>();
		hashSet.add("1");
		hashSet.add("2");
		System.out.println(hashSet.add("2")?"此对象不存在":"此对象已经存在");
		hashSet.add("3");
		hashSet.remove("3");
		for (String string : hashSet) {
			System.out.println(string);
		}
	}

}
