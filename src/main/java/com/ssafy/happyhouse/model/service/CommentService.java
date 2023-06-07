package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.dto.Comment;

public interface CommentService {

	public Comment select(int commentNo) throws SQLException;
	
	public List<Comment> selectByBoard(int articleNo) throws SQLException;
	
	public int insert(Comment comment) throws SQLException;
	
	public int update(Comment comment) throws SQLException;
	
	public int delete(int commentNo) throws SQLException;
}
