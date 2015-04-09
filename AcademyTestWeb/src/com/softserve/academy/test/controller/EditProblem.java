package com.softserve.academy.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.academy.test.model.CompetitionDB;
import com.softserve.academy.test.model.entity.Problem;
import com.softserve.academy.test.service.ProblemService;
import com.softserve.academy.test.service.ProblemServiceImpl;

/**
 * Servlet implementation class EditTask
 */
@WebServlet("/EditProblem")
public class EditProblem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProblem() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt((String) request.getParameter("taskid"));
		ProblemService ps = ProblemServiceImpl.getInstance();
		Problem problem = ps.retrieveProblem(id);
		request.setAttribute("response", problem);
		RequestDispatcher rq = request.getRequestDispatcher("EditTask.jsp");
		rq.forward(request, response);
	}

}
