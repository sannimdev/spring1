package com.spring1.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.common.Constant;
import com.spring1.common.dao.CommonDAO;

@Service("board.boardSerivce")
public class BoardServiceImpl implements BoardService, Constant {

	@Autowired
	private CommonDAO dao;

	@Override
	public List<Board> listBoard(int offset, int rows) {
		try {
			return listBoard(null, null, offset, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> listBoard(String option, String keyword, int offset, int rows) {
		List<Board> list = null;
		try {
			Map<String, Object> options = new HashMap<>();
			options.put(ATTRIBUTE_OFFSET, offset);
			options.put(ATTRIBUTE_ROWS, rows);
			if(option!=null && keyword!=null) {				
				options.put(ATTRIBUTE_OPTION, option.toLowerCase());
				options.put(ATTRIBUTE_KEYWORD, keyword);
			}
			list = dao.selectList(MAPPER_PREFIX+"listBoard", options);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long dataCount() {
		return dataCount(null, null);
	}

	@Override
	public long dataCount(String option, String keyword) {
		long dataCount = 0;
		try {
			Map<String, Object> options = new HashMap<>();
			if(option!=null && keyword!=null) {				
				options.put(ATTRIBUTE_OPTION, option.toLowerCase());
				options.put(ATTRIBUTE_KEYWORD, keyword);
			}
			dataCount = dao.selectOne(MAPPER_PREFIX+"dataCount", options);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataCount;
	}
	
	@Override
	public Board readBoard(long no) {
		Board board = null;
		try {
			board = dao.selectOne(MAPPER_PREFIX+"readBoard", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void updateViews(long no) {
		try {
			dao.updateData(MAPPER_PREFIX+"updateViews", no);
		} catch (Exception e) {
		}
	}

	@Override
	public void insertBoard(Board board) throws Exception {
		// 게시판 글 쓰기
		try {
			//TODO: 줄바꿈태그는 newline으로 변환하여 저장
			//TODO: HTML제거
			dao.insertData(MAPPER_PREFIX + "insertBoard", board);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void updateBoard(Board board) throws Exception {
		try {
			//TODO: 줄바꿈태그는 newline으로 변환하여 저장
			//TODO: HTML제거
			dao.updateData(MAPPER_PREFIX+"updateBoard", board);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	

	@Override
	public void deleteBoard(Board board) throws Exception {
		//게시판 글 지우기
		try {
			dao.deleteData(MAPPER_PREFIX+"deleteBoard", board);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	

}
