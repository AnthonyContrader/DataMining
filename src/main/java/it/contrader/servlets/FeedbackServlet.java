package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.FeedbackDTO;
import it.contrader.service.Service;
import it.contrader.service.FeedbackService;

public class FeedbackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FeedbackServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<FeedbackDTO> service = new FeedbackService();
		List<FeedbackDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<FeedbackDTO> service = new FeedbackService();
		String mode = request.getParameter("mode");
		FeedbackDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "FEEDBACKLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/feedback/feedbackmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/feedback/readfeedback.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/feedback/updatefeedback.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int vote = Integer.parseInt(request.getParameter("vote"));
			String review = request.getParameter("review").toString();
			
			
			dto = new FeedbackDTO (vote,review);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/feedback/feedbackmanager.jsp").forward(request, response);                 // qui bisogna mettere mypage manager?
		
			break;
			
		case "UPDATE":
			vote = Integer.parseInt(request.getParameter("vote"));
			review = request.getParameter("review");
			
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new FeedbackDTO (id,vote, review);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/feedback/feedbackmanager.jsp").forward(request, response);                   // vedi sopra
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/feedback/feedbackmanager.jsp").forward(request, response);
			break;
		}
	}
	
}
