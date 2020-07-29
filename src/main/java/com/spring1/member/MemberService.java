package com.spring1.member;

public interface MemberService {
	public final static String MAPPER_PREFIX="member.";
	public Member readMemberById(String memberId);
	public Member readMemberByNo(long memberNo);
	
	public void updateLastLogin(String memberId) throws Exception;
}
