package com.spring1.member;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.board.BoardController;

@RequestMapping(value="/member/*")
@RestController
public class MemberController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);

//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public Map<String, Object> login(@RequestParam String id, @RequestParam String password) {
//		Map<String, Object> map = new HashMap<>();
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error(e.getMessage());
//		}
//		return map;
//	}
}
