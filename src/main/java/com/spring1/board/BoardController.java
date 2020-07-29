package com.spring1.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.common.Constant;
import com.spring1.session.MemberSession;

@Controller("board.boardController")
@RestController
public class BoardController implements Constant {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/main")
	public Map<String, Object> main(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boardService.test();
			map.put("result","ok");
			HttpSession session = request.getSession();
			MemberSession memberSession = (MemberSession)session.getAttribute(MEMBER_SESSION);
			map.put("content", memberSession.toString());
		} catch (Exception e) {
			map.put("result", "error");
			logger.error(e.getMessage());
		}
		return map;
	}
}
