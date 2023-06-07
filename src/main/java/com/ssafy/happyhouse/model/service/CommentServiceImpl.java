package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.dto.Comment;
import com.ssafy.happyhouse.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public Comment select(int commentNo) throws SQLException {
		// TODO Auto-generated method stub
		return commentMapper.select(commentNo);
	}

	@Override
	public List<Comment> selectByBoard(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return commentMapper.selectByBoard(articleNo);
	}

	@Override
	public int insert(Comment comment) throws SQLException {
		// TODO Auto-generated method stub
		return commentMapper.insert(comment);
	}

	@Override
	public int update(Comment comment) throws SQLException {
		// TODO Auto-generated method stub
		return commentMapper.update(comment);
	}

	@Override
	public int delete(int commentNo) throws SQLException {
		// TODO Auto-generated method stub
		return commentMapper.delete(commentNo);
	}

}
