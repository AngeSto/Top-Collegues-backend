package dta.topcolleguesbackend.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dta.topcolleguesbackend.service.Initialisation;

@Component
public class InitialiserDonnees {

	@Autowired private Initialisation init;
	
	@EventListener ({ContextRefreshedEvent.class})
	void contextRefreshedEvent() {
		init.initCollegue();
	}
}
