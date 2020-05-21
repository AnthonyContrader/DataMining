package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.MyPageDTO;
import it.contrader.service.Service;
import it.contrader.service.MyPageService;

public class MyPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MyPageServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<MyPageDTO> service = new MyPageService();
		List<MyPageDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<MyPageDTO> service = new MyPageService();
		String mode = request.getParameter("mode");
		MyPageDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "MYPAGELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/myPage/usermanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/myPage/readuser.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/myPage/updateuser.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String message = request.getParameter("message").toString();
			String chronology = request.getParameter("chronology").toString();
			String disputesReports = request.getParameter("disputesReports").toString();
			
			dto = new MyPageDTO (message,chronology,disputesReports);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/myPage/usermanager.jsp").forward(request, response);                 // qui bisogna mettere mypage manager?
		
			break;
			
		case "UPDATE":
			message = request.getParameter("message");
			chronology = request.getParameter("chronology");
			disputesReports = request.getParameter("disputesReports");
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new MyPageDTO (id,message, chronology, disputesReports);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/myPage/usermanager.jsp").forward(request, response);                   // vedi sopra
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/myPage/usermanager.jsp").forward(request, response);
			break;
		}
	}
	


	
}

