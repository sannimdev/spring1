package com.spring1.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring1.common.Constant;
import com.spring1.common.Pager;

@CrossOrigin
@Controller("board.boardController")
@RequestMapping("/board/*")
@RestController
public class BoardController implements Constant {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	Pager pager;
	
	/*
	 		게시판 글 목록 (GET)
	 		/board/list
	 		  
			파라미터(page, option, keyword)
			page:게시물 요청 페이지, 없으면 기본값 1
			option: 제목+내용, 제목, 내용, 작성자
				1. title+content
				2. title
				3. content
				4. nickname
			keyword: 검색어
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam(value="page", defaultValue="1") Integer page, String option, String keyword){
		Map<String, Object> map = new HashMap<>();
		try {
			final int rows = 10; //페이지당 요청 게시물 수, 추후 파라미터로 빼기
			int offset = pager.offset(page, rows);//페이지를 변환한 오프셋
			//게시판 목록 요청
			logger.warn("###option:" + option + ", keyword:" + keyword + "###");
			List<Board> list = boardService.listBoard(option, keyword, offset, rows);
			long dataCount = boardService.dataCount(option, keyword);
			int pageCount = pager.pageCount(dataCount, rows);
			//게시판 결과 출력
			map.put(JSON_RESULT, JSON_RESULT_OK);
			map.put(JSON_BOARD_LIST, list);
			map.put(JSON_BOARD_DATA_COUNT, dataCount);
			map.put(JSON_BOARD_CURRENT_PAGE, page);
			map.put(JSON_BOARD_PAGE_COUNT, pageCount);
		} catch (Exception e) {
			logger.error("###BoardController###\t\t"+e.getMessage());
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE,e.getMessage());
		}
		return map;
	}
	
	/*
	  	게시판 글 작성(POST)
	  	/board/write
	 */
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public Map<String, Object> writeBoard(@RequestBody Board board, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		try {
			//세션에서 회원번호 추출
//			MemberSession memberSession = (MemberSession) session.getAttribute(MEMBER_SESSION);
//			long memberNo = memberSession.getMemberNo();
			long memberNo = 1;
			board.setMemberNo(1);
			//게시물 등록
			boardService.insertBoard(board);
			map.put(JSON_RESULT, JSON_RESULT_OK);
		} catch (Exception e) {
			logger.error("###BoardController###\t\t"+e.getMessage());
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	
	/*
	 		게시판 글 조회 (GET)
	 		/board/${no}
	 */
	@RequestMapping(value="{no}", method=RequestMethod.GET)
	public Map<String, Object> readBoard(@PathVariable("no") Long no){
		Map<String, Object> map = new HashMap<>();
		try {
			//조회수 1 증가
			try {
				boardService.updateViews(no);
			} catch (Exception e) {
			}
			Board board = boardService.readBoard(no);
			map.put(JSON_RESULT, JSON_RESULT_OK);
			map.put(JSON_BOARD_ITEM, board);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("###BoardController###: " + e.getMessage());
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	
	/*
	 		게시판 글 수정 (PUT)
	 		/board/${no}
	 */
	@RequestMapping(value="{no}", method=RequestMethod.PUT)
	public Map<String, Object> updateBoard(@PathVariable("no") Long no, @RequestBody Board board, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		try {
			//게시물 수정하기
//			MemberSession memberSession = (MemberSession) session.getAttribute(MEMBER_SESSION);
//			long memberNo = memberSession.getMemberNo();
			//TODO: 테스트코드
			long memberNo = 1;
			board.setMemberNo(memberNo);
			boardService.updateBoard(board);
			map.put(JSON_RESULT, JSON_RESULT_OK);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(JSON_RESULT, JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	/*
	 		게시판 글 삭제 (DELETE)
	 		/board/${no}
	 */
	@RequestMapping(value="{no}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteBoard(@PathVariable("no") Long no, HttpSession session){
		Map<String, Object> map = new HashMap<>();
		try {
//			MemberSession memberSession = (MemberSession) session.getAttribute(MEMBER_SESSION);
//			long memberNo = memberSession.getMemberNo();
//			logger.info("###debug###: 게시물번호:[" +no+"]");
			//TODO 테스트코드 지우기
			long memberNo = 1;
			Board board = new Board();
			board.setMemberNo(memberNo);
			board.setNo(no);
			boardService.deleteBoard(board);
			map.put(JSON_RESULT, JSON_RESULT_OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("###BoardController###: "+e.getMessage());
			map.put(JSON_RESULT,  JSON_RESULT_ERROR);
			map.put(JSON_ERROR_MESSAGE, e.getMessage());
		}
		return map;
	}
	
	
}
