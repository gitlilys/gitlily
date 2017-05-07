package com.gitlily.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gitlily.entity.user;
import com.gitlily.utils.DataSourceUtils;

/**
 * 
 * @author lily
 *
 */
public class loginServlet extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取输入
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
	/*	response.setContentType("text/html");
		response.getWriter().write(name + "</br>");
		response.getWriter().write(password);*/
		//2.取得数据库数据
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where name=? and password=?";
		user u = null;
		try {
			u = runner.query(sql, new BeanHandler<user>(user.class), name,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.返回结果
		if(u != null)
			response.getWriter().write(u.toString());
		else
			response.getWriter().write("sorry!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
