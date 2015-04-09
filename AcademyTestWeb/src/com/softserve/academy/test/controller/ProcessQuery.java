package com.softserve.academy.test.controller;

import com.softserve.academy.test.DAO.*;
import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.model.entity.Problem;
import com.softserve.academy.test.service.CompetitionService;
import com.softserve.academy.test.service.CompetitionServiceImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessQuery
 */
@WebServlet("/GetCompetitions")
public class ProcessQuery extends HttpServlet {
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
//		CompetitionDAO cs = CompetitionHBN.getInstance();
//		HashSet<Competition> result = new HashSet<Competition>(cs.retrieveAllCompetitions());
//		request.setAttribute("response", result);
		RequestDispatcher rq = request.getRequestDispatcher("competitions.jsp");
		rq.forward(request, response);
	}
}