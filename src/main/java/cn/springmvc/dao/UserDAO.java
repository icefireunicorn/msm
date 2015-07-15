package cn.springmvc.dao;

import cn.springmvc.model.User;

public interface UserDAO {
	/**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    
    User getUser(final int id);
    
    void saveUser(final User user);
}
