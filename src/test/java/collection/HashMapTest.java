package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月20日 上午10:03:24
 */
public class HashMapTest {

	public static void main(String[] args) {
		Map<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("1", "Tom");
		hashMap.put("2", "Jack");
		//循环方式1
		for(Entry<String, String> entry:hashMap.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		//循环方式2
		Iterator<Map.Entry<String, String>> iter = hashMap.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>)iter.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
