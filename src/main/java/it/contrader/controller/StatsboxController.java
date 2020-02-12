package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Player;
import it.contrader.model.User.Usertype;
import it.contrader.service.PlayerService;
import it.contrader.service.StatsboxService;

@Controller
@RequestMapping("/statsbox")
public class StatsboxController {
	
	@Autowired
	private StatsboxService service;
	@Autowired
	private PlayerService playerservice;
	private PlayerConverter playerconverter;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "statsbox/statsboxes";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "statsbox/statsboxes";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "statsbox/updatestats";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("player") Player player, @RequestParam("season") int season, @RequestParam("caps") int caps, @RequestParam("contributions") float contributions, @RequestParam("shotsper") float shotsper, @RequestParam("keypass") float keypass, @RequestParam("passprec") float passprec, @RequestParam("dribbling") float dribbling, @RequestParam("foulssub") float foulssub, @RequestParam("foulscomm") float foulscomm, @RequestParam("tackles") float tackles, @RequestParam("tacklesper") float tacklesper, @RequestParam("breaks") float breaks) {

		StatsboxDTO dto = new StatsboxDTO();
		dto.setId(id);
		dto.setPlayer(player);
		dto.setSeason(season);
		dto.setCaps(caps);
		dto.setContributions(contributions);
		dto.setShotsper(shotsper);
		dto.setKeypass(keypass);
		dto.setPassprec(passprec);
		dto.setDribbling(dribbling);
		dto.setFoulssub(foulssub);
		dto.setFoulscomm(foulscomm);
		dto.setTackles(tackles);
		dto.setTacklesper(tacklesper);
		dto.setBreaks(breaks);
		service.update(dto);
		setAll(request);
		return "statsbox/statsboxes";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("player") int id_player, @RequestParam("season") int season, @RequestParam("caps") int caps, @RequestParam("contributions") float contributions, @RequestParam("shotsper") float shotsper, @RequestParam("keypass") float keypass, @RequestParam("passprec") float passprec, @RequestParam("dribbling") float dribbling, @RequestParam("foulssub") float foulssub, @RequestParam("foulscomm") float foulscomm, @RequestParam("tackles") float tackles, @RequestParam("tacklesper") float tacklesper, @RequestParam("breaks") float breaks) {
		StatsboxDTO dto = new StatsboxDTO();
		
		Player player = playerconverter.toEntity(playerservice.read(id_player));
		dto.setPlayer(player);
		dto.setSeason(season);
		dto.setCaps(caps);
		dto.setContributions(contributions);
		dto.setShotsper(shotsper);
		dto.setKeypass(keypass);
		dto.setPassprec(passprec);
		dto.setDribbling(dribbling);
		dto.setFoulssub(foulssub);
		dto.setFoulscomm(foulscomm);
		dto.setTackles(tackles);
		dto.setTacklesper(tacklesper);
		dto.setBreaks(breaks);
		setAll(request);
		return "statsbox/statsboxes";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "statsbox/readstats";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

