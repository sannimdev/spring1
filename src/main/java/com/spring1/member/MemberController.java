package com.spring1.member;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.board.BoardController;

@Controller
@RequestMapping(value="/member/*")
//@RestController
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);

//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public Map<String, Object> login() {
//		Map<String, Object> map = new HashMap<>();
//		try {
//			map.put("login", "required");
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		return map;
//	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		logger.info("로그인");
		return "member/login";
	}
	
	@RequestMapping(value="test")
	public String test() {
		return "member/login";
	}
}
