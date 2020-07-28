package com.spring1.board;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("board.boardController")
@RestController
public class BoardController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/main")
	public Map<String, Object> main(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boardService.test();
			map.put("result","ok");
		} catch (Exception e) {
			map.put("result", "error");
			logger.error(e.getMessage());
		}
		return map;
	}
}
