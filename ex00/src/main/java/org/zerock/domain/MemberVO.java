package org.zerock.domain;

import java.util.Date;

public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date regdate;
	private Date updatedate; //처음에는 빨간불이 들어올 것이다. 이유는 Date타입이 없기떄문이다. 
	                         // 따라서 ctrl+shift+O를 누르고 sql이 아닌 unit을 추가해주면 됨
	
	
	//값을 자동으로 넣음 ( 알트+시피트+O를 누르고 컨스트럭터를 추가해주면된다 //junit에 전부 입력안해도 된다. 손쉽게하는 튜닝 tip)
	public MemberVO(String userid, String userpw, String username, String email) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}
	
	
	public String getUserid() {  //get&set은 alt+shift+R해서 전부선택해서 넣어주면 끝 
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	// toString을 할 필요는 없지만 굳이한다면 로그를 찍어보겠다고 한다면 
		// 알트+시피트+S 눌르고 toString선택 해주면 됨
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", email=" + email
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}


	
}
