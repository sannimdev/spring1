package com.spring1.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.common.dao.CommonDAO;

@Service("board.boardSerivce")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private CommonDAO dao;

	@Override
	public List<Board> listBoard() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Board> listBoard(String option, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long dataCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long dataCount(String option, String keyword) {
		// TODO Auto-generated method stub
		return 0;
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
