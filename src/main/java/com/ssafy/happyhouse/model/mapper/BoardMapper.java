package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Board;

@Mapper
public interface BoardMapper {
	
	public Board select(int articleNo) throws SQLException;
	
	public List<Board> selectAll() throws SQLException;
	
	public List<Board> selectBySubject(String subject) throws SQLException;
	
	public List<Board> selectById(String id) throws SQLException;
	
	public int insert(Board board) throws SQLException;
	
	public int update(Board board) throws SQLException;
	
	public int delete(int articleNo) throws SQLException;
	
	// 따로 조회수 올리는 기능
	//public int updateHit(int articleNo) throws SQLException;
}
