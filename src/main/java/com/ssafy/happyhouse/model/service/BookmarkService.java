package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Bookmark;
import com.ssafy.happyhouse.model.dto.Rank;

public interface BookmarkService {
	public Bookmark select(int bookmarkNo) throws SQLException;
	
	public List<Bookmark> selectById(String userId) throws SQLException;
	
	public List<Rank> selectOrderBy() throws SQLException;
	
	public int insert(Bookmark bookmark) throws SQLException;
	
	
	public int delete(int bookmarkNo) throws SQLException;
}
