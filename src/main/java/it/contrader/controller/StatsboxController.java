package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.PlayerConverter;
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
	private PlayerService playerService;
	@Autowired
	private PlayerConverter playerConverter;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		if (userDTO.getUsertype().equals(Usertype.USER)) {
			return "statsbox/readallstats";
		}
		else if (userDTO.getUsertype().equals(Usertype.ADMIN)) {
			return "statsbox/statsboxes";	
		}
		else return "index";
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
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("player_id") int player_id, @RequestParam("season") int season, @RequestParam("caps") int caps, @RequestParam("contributions") float contributions, @RequestParam("shotsper") float shotsper, @RequestParam("keypass") float keypass, @RequestParam("passprec") float passprec, @RequestParam("dribbling") float dribbling, @RequestParam("foulssub") float foulssub, @RequestParam("foulscomm") float foulscomm, @RequestParam("tackles") float tackles, @RequestParam("tacklesper") float tacklesper, @RequestParam("breaks") float breaks) {

		StatsboxDTO dto = new StatsboxDTO();
		dto.setId(id);
		Player player = playerConverter.toEntity(playerService.read(player_id));
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
	public String insert(HttpServletRequest request, @RequestParam("player_id") int player_id, @RequestParam("season") int season, @RequestParam("caps") int caps, @RequestParam("contributions") float contributions, @RequestParam("shotsper") float shotsper, @RequestParam("keypass") float keypass, @RequestParam("passprec") float passprec, @RequestParam("dribbling") float dribbling, @RequestParam("foulssub") float foulssub, @RequestParam("foulscomm") float foulscomm, @RequestParam("tackles") float tackles, @RequestParam("tacklesper") float tacklesper, @RequestParam("breaks") float breaks) {
		StatsboxDTO dto = new StatsboxDTO();
		Player player = playerConverter.toEntity(playerService.read(player_id));
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
		service.insert(dto);
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

