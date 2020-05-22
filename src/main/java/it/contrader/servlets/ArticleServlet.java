package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ArticleDTO;
import it.contrader.service.Service;
import it.contrader.service.ArticleService;

public class ArticleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ArticleServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ArticleDTO> service = new ArticleService();
		List<ArticleDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ArticleDTO> service = new ArticleService();
		String mode = request.getParameter("mode");
		ArticleDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "ARTICLELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/article/articlemanager.jsp").forward(request, response);                  //qui metto article?
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/article/readarticle.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/article/updatearticle.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			int price =Integer.parseInt(request.getParameter("price"));
			dto = new ArticleDTO (name,description,price);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/article/usermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			price = Integer.parseInt(request.getParameter("price"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ArticleDTO (id,name, description, price);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/article/usermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/article/usermanager.jsp").forward(request, response);
			break;
		}
	}

}
