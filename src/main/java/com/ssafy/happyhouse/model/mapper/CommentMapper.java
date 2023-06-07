package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.dto.Comment;

@Mapper
public interface CommentMapper {
	
	public Comment select(int commentNo) throws SQLException;
	
	public List<Comment> selectByBoard(int articleNo) throws SQLException;
	
	public int insert(Comment comment) throws SQLException;
	
	public int update(Comment comment) throws SQLException;
	
	public int delete(int commentNo) throws SQLException;
	
}
