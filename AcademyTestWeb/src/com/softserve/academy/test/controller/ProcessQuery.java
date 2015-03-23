package com.softserve.academy.test.controller;

import com.softserve.academy.test.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessQuery
 */
@WebServlet("/ProcessQuery")
public class ProcessQuery extends HttpServlet {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/AcademyTest";
	static final String USER = "root";
	static final String PASS = "root";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessQuery() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// try {
		// Class.forName(JDBC_DRIVER);
		// Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// String query = "it works!";
		// conn.close();
		// } catch (SQLException ex) {
		// System.out.println("sql exception");
		// ex.printStackTrace();
		// }
		// catch (ClassNotFoundException clnfe){
		// System.out.println("Class not found exception");
		// clnfe.printStackTrace();
		// }
//		String query = request.getParameter("query");
		CompetitionDB cbd = CompetitionDB.getInstance();
//		System.out.println(cbd);
		ArrayList<Competition> c = cbd.readAllCompetitions();
//		System.out.println(c);
		request.setAttribute("response", c);
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);

	}
	// public static void main(String[] args){
	// CompetitionDB cbd = CompetitionDB.getInstance();
	// Competition competition = cbd.readFromDB(15);
	//
	// }
}