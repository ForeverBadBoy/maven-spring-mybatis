package cn.com.kid.pojo;

public class User {
	private int uid;
	private String userName;
	private String passWord;
	
	public User(){
	}
	
	public User(int uid, String userName, String passWord) {
		//super();
		this.uid = uid;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	
}
