package cn.springmvc.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;

/**
 * @Description:TODO
 * @author:caikx
 * @time:2015年6月26日 下午4:07:34
 */
public class UserDAOImpl implements UserDAO {

	@Resource
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	public void saveUser(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(redisTemplate.getStringSerializer().serialize("user.uid." + user.getId()), redisTemplate
						.getStringSerializer().serialize(user.getName()));
				return null;
			}
		});
	}

	@Override
	public User getUser(final int id) {
		return redisTemplate.execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize("user.uid." + id);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String name = redisTemplate.getStringSerializer().deserialize(value);
					User user = new User();
					user.setName(name);
					user.setId(id);
					return user;
				}
				return null;
			}
		});
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:conf/spring-redis.xml");
		UserDAO userDAO = (UserDAO) ac.getBean("userDAO");
		User user1 = new User();
		user1.setId(1);
		user1.setName("obama");
		userDAO.saveUser(user1);
		User user2 = userDAO.getUser(1);
		System.out.println(user2.getName());
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
}
