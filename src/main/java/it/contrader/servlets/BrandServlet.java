package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.BrandDTO;
import it.contrader.service.Service;
import it.contrader.service.BrandService;

public class BrandServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BrandServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<BrandDTO> service = new BrandService();
		List<BrandDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<BrandDTO> service = new BrandService();
		String mode = request.getParameter("mode");
		BrandDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "BRANDLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/brand/brandmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/brand/readbrand.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/brand/updatebrand.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String category = request.getParameter("category").toString();
			
			dto = new BrandDTO (name,category);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/brand/brandmanager.jsp").forward(request, response);                 // qui bisogna mettere brand manager?
		
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			category = request.getParameter("category");
			
			id = Integer.parseInt(request.getParameter("id"));
			dto = new BrandDTO (id,name, category);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/brand/brandmanager.jsp").forward(request, response);                   // vedi sopra
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/brand/brandmanager.jsp").forward(request, response);
			break;
		}
	}
	
}
