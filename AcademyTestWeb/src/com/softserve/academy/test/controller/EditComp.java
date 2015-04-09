package com.softserve.academy.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.academy.test.DAO.CompetitionDAO;
import com.softserve.academy.test.DAO.CompetitionHBN;
import com.softserve.academy.test.DAO.HibernateUtil;
import com.softserve.academy.test.model.CompetitionDB;
import com.softserve.academy.test.model.entity.Competition;
import com.softserve.academy.test.service.CompetitionService;
import com.softserve.academy.test.service.CompetitionServiceImpl;

/**
 * Servlet implementation class EditComp
 */
@WebServlet("/EditComp")
public class EditComp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditComp() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			CompetitionService cs = CompetitionServiceImpl.getInstance();
			Competition comp = cs.retrieveCompetition(id);
			request.setAttribute("response", comp);
			RequestDispatcher rq = request
					.getRequestDispatcher("EditCompetition.jsp");
			rq.forward(request, response);
		}
		if (action.equals("Delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			CompetitionService cs = CompetitionServiceImpl.getInstance();
			cs.deleteCompetition(id);
			RequestDispatcher rq = request
					.getRequestDispatcher("DeleteCompetition.jsp");
			rq.forward(request, response);	
		}
	}

}
