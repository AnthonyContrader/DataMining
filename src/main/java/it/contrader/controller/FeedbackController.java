package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;
import it.contrader.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService service;

	/*@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		request.getSession().setAttribute("user", userDTO);

		switch (userDTO.getUsertype()) {

		case ADMIN:
			return "homeadmin";

		case USER:
			return "index";

		default:
			return "index";
		}
	}*/

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "feedbacks";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "feedbacks";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatefeedback";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("vote") int vote,
			@RequestParam("review") String review) {

		FeedbackDTO dto = new FeedbackDTO();
		dto.setId(id);
		dto.setVote(vote);
		dto.setReview(review);
		service.update(dto);
		setAll(request);
		return "platforms";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("vote") int vote,
			@RequestParam("review") String review) {
		FeedbackDTO dto = new FeedbackDTO();
		dto.setId(id);
		dto.setVote(vote);
		dto.setReview(review);
		service.insert(dto);
		setAll(request);
		return "feedbacks";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readfeedback";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}