package com.softserve.academy.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.academy.test.model.CompetitionDB;
import com.softserve.academy.test.model.Problem;

/**
 * Servlet implementation class UpdateTask
 */
@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTask() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Update")) {
			int id = Integer.parseInt(request.getParameter("taskId"));
			String difficulty = request.getParameter("difficulty");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			Problem problem = new Problem();
			problem.setId(id);
			problem.setDifficultyByName(difficulty);
			problem.setName(name);
			problem.setDescription(description);
			CompetitionDB cdb = CompetitionDB.getInstance();
			cdb.updateProblem(problem);
		}
		if (action.equals("Delete from competition")) {
			int problemId = Integer.parseInt(request.getParameter("taskId"));
			int compId = Integer.parseInt(request.getParameter("compId"));
			
		}
		if (action.equals("Delete from database")) {
		}
	}

}
