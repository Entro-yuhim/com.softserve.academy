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
	private static final long serialVersionUID = 1L;
	private boolean SHOWING_COMPETITIONS;
	private boolean SHOWING_PROBLEMS;

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
		// String query = request.getParameter("query");
		String action = request.getParameter("action");
		if ("Get competitions".equals(action)) {
			showCompetitions(request, response);
			SHOWING_COMPETITIONS = true;
			SHOWING_PROBLEMS = false;
		}
		if ("Edit competition".equals(action)) {
			showProblems(request, response);
			SHOWING_COMPETITIONS = false;
			SHOWING_PROBLEMS = true;
		}

	}

	// public static void main(String[] args){
	// CompetitionDB cbd = CompetitionDB.getInstance();
	// Competition competition = cbd.readFromDB(15);
	//
	// }
	private static void showCompetitions(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CompetitionDB cbd = CompetitionDB.getInstance();
		ArrayList<Competition> c = cbd.readAllCompetitions();
		request.setAttribute("response", c);
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);
	}

	private static void showProblems(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CompetitionDB cdb = CompetitionDB.getInstance();
		Competition comp = cdb.readFromDB(id);
		request.setAttribute("response", comp);
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);
	}
}