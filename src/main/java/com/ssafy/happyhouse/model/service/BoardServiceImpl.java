package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Board select(int articleNo) throws SQLException {
		return boardMapper.select(articleNo);
	}

	@Override
	public List<Board> selectAll() throws SQLException {
		return boardMapper.selectAll();
	}
	
	@Override
	public List<Board> selectBySubject(String subject) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(subject);
		return boardMapper.selectBySubject(subject);
	}

	@Override
	public List<Board> selectById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return boardMapper.selectById(id);
	}
	
	
	@Override
	public boolean insert(Board board) throws SQLException {
		return boardMapper.insert(board) == 1;
	}

	@Override
	public boolean update(Board board) throws SQLException {
		return boardMapper.update(board) == 1;
	}

	@Override
	public boolean delete(int articleNo) throws SQLException {
		return boardMapper.delete(articleNo) == 1;
	}


	
	
	// 따로 조회수 올리는 기능
//	@Override
//	public boolean updateHit(int articleNo) throws SQLException {
//		return boardMapper.updateHit(articleNo) == 1;
//	}

}
