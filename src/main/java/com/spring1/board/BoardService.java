package com.spring1.board;

import java.util.List;

public interface BoardService {
	public final static String MAPPER_PREFIX="board.";
	
	public List<Board> listBoard(int offset, int rows);
	public List<Board> listBoard(String option, String keyword, int offset, int rows);
	public long dataCount();
	public long dataCount(String option, String keyword);
	
	public Board readBoard(long no);
	public void updateViews(long no);
	public void insertBoard(Board board) throws Exception;
	public void updateBoard(Board board) throws Exception;
	public void deleteBoard(Board board) throws Exception;
}
