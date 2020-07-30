package com.spring1.common;

public interface Constant {
	//세션 관련
	public final static String MEMBER_SESSION = "member";
	//속성 관련
	public final static String ATTRIBUTE_MEMBERNO = "memberNo";
	public final static String ATTRIBUTE_BOARDNO = "no";
	public final static String ATTRIBUTE_OPTION = "option";
	public final static String ATTRIBUTE_KEYWORD ="keyword";
	public final static String ATTRIBUTE_OFFSET = "offset";
	public final static String ATTRIBUTE_ROWS = "rows";
	/*이하 JSON*/
	
	//공통
	public final static String JSON_RESULT = "result";
	public final static String JSON_RESULT_OK = "ok";
	public final static String JSON_RESULT_ERROR = "error";
	public final static String JSON_ERROR_MESSAGE = "error_message";
	public final static String JSON_MEMBER = "member";
	
	//로그인 관련
	public final static String JSON_LOGIN = "login";
	public final static String JSON_LOGIN_SUCCESS= "success";
	public final static String JSON_LOGIN_FAILURE = "failure";
	
	//게시판 관련
	public final static String JSON_BOARD_DATA_COUNT = "data_count";
	public final static String JSON_BOARD_LIST = "items";
	public final static String JSON_BOARD_PAGE_COUNT = "page_count";
	public final static String JSON_BOARD_CURRENT_PAGE = "current_page";
	public final static String JSON_BOARD_ITEM = "item";
	
	public final static String JSON_BOARD_SEARCH_TITLE_AND_CONTENT = "titlecontent";
	public final static String JSON_BOARD_SEARCH_TITLE = "title";
	public final static String JSON_BOARD_SEARCH_CONTENT ="content";
	public final static String JSON_BOARD_SEARCH_NICKNAME = "nickname";
}
