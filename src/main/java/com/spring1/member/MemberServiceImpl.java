package com.spring1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.common.dao.CommonDAO;

@Service("member.memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	CommonDAO dao;
	
	@Override
	public Member readMemberById(String memberId) {
		Member member = null;
		try {
			member = dao.selectOne(MAPPER_PREFIX+"readMemberById", memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	@Override
	public Member readMemberByNo(long memberNo) {
		Member member = null;
		try {
			member = dao.selectOne(MAPPER_PREFIX+"readMemberByNo", memberNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public void updateLastLogin(String memberId) throws Exception {
		try {
			dao.updateData(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
}
