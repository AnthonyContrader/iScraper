package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.InjuryDTO;
import it.contrader.model.Player;
import it.contrader.service.InjuryService;

@Controller

@RequestMapping("/injury")
public class InjuryController {

	@Autowired
	private InjuryService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "injury/injuries";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") long id) {
		service.delete(id);
		setAll(request);
		return "injury/injuries";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "injury/updateinjury";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("severity") int severity,
			@RequestParam("description") String description, @RequestParam("duration") int duration,
			@RequestParam("date") String date, @RequestParam("player") Player player) {
		
		InjuryDTO dto = new InjuryDTO();
		dto.setId(id);
		dto.setSeverity(severity);
		dto.setDescription(description);
		dto.setDuration(duration);
		dto.setDate(date);
		dto.setPlayer(player);
		service.update(dto);
		setAll(request);
		return "injury/injuries";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("severity") int severity,
			@RequestParam("description") String description, @RequestParam("duration") int duration,
			@RequestParam("date") String date, @RequestParam("player") Player player) {
		InjuryDTO dto = new InjuryDTO();
		dto.setSeverity(severity);
		dto.setDescription(description);
		dto.setDuration(duration);
		dto.setDate(date);
		dto.setPlayer(player);
		service.insert(dto);
		setAll(request);
		return "injury/injuries";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "injury/injuries";
	}
	
	@GetMapping("/readinjury")
	public String readInjury(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "injury/readinjury";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
