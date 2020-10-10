package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostDao {

	public int 글쓰기(Post post) {
		// 1. 회원가입 진행(Insert), Model로 이동
		String sql = "INSERT INTO post(userId,title,content,readCount, createDate) VALUES(?,?,?,?,now())";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getUserId());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getContent());
			pstmt.setInt(4, post.getReadCount());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int 조회수증가(int id) {
		String sql = "UPDATE post SET readCount = readCount+1 WHERE id =?";
		Connection conn = DBConn.getInstance();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	public Post 상세보기(int id) {

		String sql = "SELECT * FROM post WHERE id = ?";
		Connection conn = DBConn.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Post post = new Post(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getInt("readCount"), rs.getTimestamp("createDate"), rs.getInt("userId")

				);
				return post;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Post> 글목록() {
		List<Post> posts = new ArrayList<>();

		// ORDER 순서대로 , DESC 내림 차순 or ASC 정상순
		String sql = "SELECT * FROM post ORDER BY id DESC";

		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Post post = new Post(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getInt("readCount"), rs.getTimestamp("createDate"), rs.getInt("userId"));
				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
