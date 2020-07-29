package com.spring1.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.spring1.common.Constant;
import com.spring1.member.Member;
import com.spring1.member.MemberService;
import com.spring1.session.MemberSession;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements Constant{
	
	@Autowired
	private MemberService memberService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
			
		HttpSession session=request.getSession(true);
		String memberId = authentication.getName(); //memberId
		try {
			memberService.updateLastLogin(memberId);
		} catch (Exception e) {
		}
		Member member = memberService.readMemberById(memberId);
		MemberSession memberSession = new MemberSession(
				member.getMemberNo(),
				member.getMemberId(),
				member.getNickname(),
				member.getLastLogin()
		);
		session.setAttribute(MEMBER_SESSION, memberSession);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	
}
