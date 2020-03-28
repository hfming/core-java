package com.hfm.collection.set.hashset;
/**
 * 用户类
 * @author hfm
 */
public class User {
	private int id;
	private String userName;
	private String passWord;
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		User user = null;
		if(obj instanceof User){
			user = (User) obj;
		}
		if(user.getId()==this.id&&user.getUserName().equals(this.userName)&&user.getPassWord().equals(this.passWord)){
			return true;
		}
		return false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
