package sec04.ex04;

import java.sql.Date;

public class MemberVO {
	private int mno; // 회원번호
	private String id; // 아이디
	private String name; // 이름
	private String password; // 비밀번호
	private String email; // 이메일
	private Date joinDate; // 가입일
	
	public MemberVO(int mno, String id, String name, String password, String email) {
		this.mno = mno;
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", id=" + id + ", name=" + name + ", email=" + email + ", joinDate=" + joinDate
				+ "]";
	}
	

}