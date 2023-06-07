package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Bookmark;
import com.ssafy.happyhouse.model.dto.Rank;
import com.ssafy.happyhouse.model.mapper.BookmarkMapper;

@Service
public class BookmarkServiceImpl implements BookmarkService {
	
	@Autowired
	BookmarkMapper bookmarkMapper;

	@Override
	public Bookmark select(int bookmarkNo) throws SQLException {
		// TODO Auto-generated method stub
		return bookmarkMapper.select(bookmarkNo);
	}

	@Override
	public List<Bookmark> selectById(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return bookmarkMapper.selectById(userId);
	}

	@Override
	public int insert(Bookmark bookmark) throws SQLException {
		// TODO Auto-generated method stub
		return bookmarkMapper.insert(bookmark);
	}

	@Override
	public int delete(int bookmarkNo) throws SQLException {
		// TODO Auto-generated method stub
		return bookmarkMapper.delete(bookmarkNo);
	}

	@Override
	public List<Rank> selectOrderBy() throws SQLException {
		return bookmarkMapper.selectOrderBy();
	}

}
