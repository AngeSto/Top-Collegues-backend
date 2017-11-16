package dta.topcolleguesbackend.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dta.topcolleguesbackend.entite.Collegue;
import dta.topcolleguesbackend.repository.CollegueRepository;

@Service
public class Initialisation {
	
	@Autowired private CollegueRepository colServ;
	
	public void initCollegue(){
		if(colServ.count()  == 0) {
			Stream.of(new Collegue("Benjamin", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAy2AAAAJGQ4ZjNkNDRhLTg5MGQtNGY3MC1hODA1LTcyODk1Y2ViYzg4Yg.jpg", 20),
					  new Collegue("Ange", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAm9AAAAJGFlNjI3NmZmLTc5ZDMtNDA1Zi05MjBiLWM1OTNmZmY2MjM2ZA.jpg", 9999),
					  new Collegue("Joris", "https://lol.seek-team.com/images/medals/silver_1.png?v22", -9999),
					  new Collegue("Julien", "https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/17951618_1589493484416070_6489814754820572271_n.jpg?oh=fcdb12ea810e3b764282dc00424a3fa9&oe=5A8FE65E", 0),
					  new Collegue("Florent", "https://avatars3.githubusercontent.com/u/32134408?s=400&v=4", -20))
			.forEach(colServ::save);
		}
		
	}

}
