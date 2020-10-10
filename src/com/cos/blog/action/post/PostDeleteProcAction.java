package com.cos.blog.action.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostDeleteProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("딜리트 호출됨");
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter pw = response.getWriter(); 
		
		//PostDao 연결
		//int result = 삭제하기(id);
		
		pw.print("다운받은 데이터");
		pw.flush();

	}

}
