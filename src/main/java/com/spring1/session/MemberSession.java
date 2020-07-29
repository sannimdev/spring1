package com.spring1.session;

public class MemberSession {
	private long memberNo;
	private String memberId;
	private String nickname;
	private String lastLogin;
	public long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	
	public MemberSession(long memberNo, String memberId, String nickname, String lastLogin) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.nickname = nickname;
		this.lastLogin = lastLogin;
	}
	
}