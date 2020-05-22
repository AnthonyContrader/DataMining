package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.PlatformDTO;
import it.contrader.service.Service;
import it.contrader.service.PlatformService;

public class PlatformServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public PlatformServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<PlatformDTO> service = new PlatformService();
		List<PlatformDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PlatformDTO> service = new PlatformService();
		String mode = request.getParameter("mode");
		PlatformDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "PLATFORMLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/platform/platformmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/platform/readplatform.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/platform/updateplatform.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			String website = request.getParameter("website").toString();
			dto = new PlatformDTO (name,description,website);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/platform/platformmanager.jsp").forward(request, response);                 // qui bisogna mettere paltform manager?
		
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			website = request.getParameter("website");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new PlatformDTO (id,name, description, website);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/platform/usermanager.jsp").forward(request, response);                   // vedi sopra
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/platform/platformmanager.jsp").forward(request, response);
			break;
		}
	}

}
