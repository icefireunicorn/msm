package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年7月15日 下午2:56:47
 */
public class MybatisStart {

	private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;  
	private static SqlSessionFactory sqlSessionFactory;  
	private static void init() throws IOException {  
	    String resource = "mybatis-config.xml";  
	    Reader reader = Resources.getResourceAsReader(resource);  
	    sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();  
	    sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
	    SqlSession session= sqlSessionFactory.openSession();  
//	    UserDao userDao = session.getMapper(UserDao.class);  
//	    UserDto user = new UserDto();  
//	    user.setUsername("iMybatis");  
//	    List<UserDto> users = userDao.queryUsers(user);
	}  
}
