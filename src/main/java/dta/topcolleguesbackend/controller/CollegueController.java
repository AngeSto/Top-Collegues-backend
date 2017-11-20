package dta.topcolleguesbackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dta.topcolleguesbackend.entite.Collegue;
import dta.topcolleguesbackend.repository.CollegueRepository;

@RestController
@RequestMapping("/collegues")
@CrossOrigin(origins = {"http://localhost:4200", "https://dist-kinmaeruzc.now.sh"})
public class CollegueController {
	
	@Autowired private CollegueRepository colServ;
	
	@GetMapping
	public List<Collegue> getCollegue(){
		return colServ.findAll();
	}
	
	@PostMapping
	public void postCollegue(@RequestBody Collegue col){
		Optional <Collegue> opt = colServ.findAll().stream().filter(collegue -> collegue.getNom().equals(col.getNom())).findFirst();
		if(!opt.isPresent()){
			colServ.save(col);
		}
		
	}
	
	@PutMapping("{pseudo}/score")
	public Collegue putCollegue(@RequestBody Map<String, String> map, @PathVariable String pseudo){
		Optional<Collegue> opt = colServ.findAll().stream().filter(collegue -> collegue.getNom().equals(pseudo)).findFirst();
		Collegue col = new Collegue();
		if(opt.isPresent()){
			if(map.get("avis").equals("jaime")){
				col = opt.get();
				col.setScore(col.getScore()+10);
				colServ.save(col);	
			}
			if(map.get("avis").equals("jeDeteste")){
				col = opt.get();
				col.setScore(col.getScore()-5);
				colServ.save(col);	
			}
			
		}
		return col;
	}

}
