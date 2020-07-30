package com.spring1.common;

import org.springframework.stereotype.Service;

@Service("common.Pager")
public class Pager {
	public int offset(int page, int rows) {
		return page == 1 ? 0 : (page - 1) * rows;
	}

	public int pageCount(long dataCount, int rows) {
		int pageCount = (int)(dataCount / rows);
		return dataCount % rows > 0 ? pageCount + 1 : pageCount;
	}
}
