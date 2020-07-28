package com.spring1.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.common.dao.CommonDAO;

@Service("board.boardSerivce")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private CommonDAO dao;

	
	@Override
	public void test() {
		try {
			dao.insertData(MAPPER_PREFIX+"insertTest", "test임...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
