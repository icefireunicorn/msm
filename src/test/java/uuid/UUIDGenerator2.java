package uuid;

import java.util.UUID;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年5月11日 下午7:04:24
 */
public class UUIDGenerator2 {

	/** 
     * @Title: generaterPrimaryKey 
     * @Description: 以UUID的方式生成主键 
     * @return String : 主键值 
     */  
    public static synchronized String generaterPrimaryKey() throws Exception{  
          
        UUID uuid = UUID.randomUUID();  
          
        if (null==uuid || "".equals(uuid.toString())){  
            throw new NullPointerException("uuid is null");  
        }  
          
        String primaryKey = String.valueOf(uuid);  
          
        if (null!=primaryKey && primaryKey.contains("-")){  
            primaryKey = primaryKey.replaceAll("-", "");  
        }  
          
        return primaryKey;  
    }  
    
    public static void main(String[] args) {
    	try {
			System.out.println(UUIDGenerator2.generaterPrimaryKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
