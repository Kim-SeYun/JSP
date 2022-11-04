package sec01.ex03;

import java.sql.Date;

public class MemberVO {
	private String uId;
	private String pwd;
	private String uName;
	private String email;
	private Date date;
	
	public MemberVO(String uId, String pwd, String uName, String email, Date date) {
		this.uId = uId;
		this.pwd = pwd;
		this.uName = uName;
		this.email = email;
		this.date = date;
	}
	public MemberVO(String uId, String pwd, String uName, String email) {
		this.uId = uId;
		this.pwd = pwd;
		this.uName = uName;
		this.email = email;
		
	}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MemberVO [uId=" + uId + ", pwd=" + pwd + ", uName=" + uName + ", email=" + email + ", date=" + date
				+ "]";
	}
	
	
	

}
