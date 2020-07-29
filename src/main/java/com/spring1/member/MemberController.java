package com.spring1.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.board.BoardController;
import com.spring1.common.Constant;
import com.spring1.session.MemberSession;

@Controller
@RequestMapping(value="/member/*")
@RestController
public class MemberController implements Constant{
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Map<String, Object> login(@RequestBody Member requestMember, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		Member member = null;
		try {
			String memberId = requestMember.getMemberId();
			String password =requestMember.getPassword();
			logger.warn("id:"+memberId);
			member = memberService.readMemberById(memberId);
			String encryptedPassword = password; //TODO: 암호화
			if(member != null && member.getPassword().equals(encryptedPassword)) {
				//로그인 성공
				try {
					memberService.updateLastLogin(memberId);
				} catch (Exception e) {
				}
				MemberSession memberSession = new MemberSession(member.getMemberNo(), member.getMemberId(), member.getNickname(), member.getLastLogin());
				session.setAttribute(MEMBER_SESSION, memberSession);
				map.put(JSON_RESULT, JSON_RESULT_OK);
				map.put(JSON_LOGIN, JSON_LOGIN_SUCCESS);
				map.put(JSON_MEMBER, memberSession.getMap());
			}else {
				map.put(JSON_RESULT,  JSON_RESULT_ERROR);
				map.put(JSON_LOGIN, JSON_LOGIN_FAILURE);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	@RequestMapping(value="/logout")
	public Map<String, Object> logout(HttpSession session){
		Map<String, Object> map = new HashMap<>();
		try {
			session.invalidate();
			map.put(JSON_RESULT, JSON_RESULT_OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	
}
