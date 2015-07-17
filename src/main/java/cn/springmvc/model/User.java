package cn.springmvc.model;

import java.io.Serializable;

/**
 * 用户表
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5427066391164091412L;
	private int id;
	private int state;
	private String nickname;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
