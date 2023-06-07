package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Board;

public interface BoardService {

	public Board select(int articleNo) throws SQLException;

	public List<Board> selectAll() throws SQLException;

	public List<Board> selectBySubject(String subject) throws SQLException;

	public List<Board> selectById(String id) throws SQLException;

	public boolean insert(Board board) throws SQLException;

	public boolean update(Board board) throws SQLException;

	public boolean delete(int articleNo) throws SQLException;

	// 따로 조회수 올리는 기능
	// public boolean updateHit(int articleNo) throws SQLException;
}
