package dta.topcolleguesbackend.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dta.topcolleguesbackend.entite.Vote;
import dta.topcolleguesbackend.repository.VoteRepository;

@RestController
@RequestMapping("/vote")
@CrossOrigin(origins = { "*" })
public class VoteController {
	@Autowired
	private VoteRepository voteServ;

	@GetMapping
	public List<Vote> getCollegue(@RequestParam("since") Optional<Integer> id) {
		if (id.isPresent()){
			return voteServ.findSinceId(id.get());
		}
		List<Vote> listVote = voteServ.findAll();
		if (listVote.size() > 3){
			listVote = listVote.subList(listVote.size()-3, listVote.size());
		}
		return listVote;
	}

	@PostMapping
	public Vote postCollegue(@RequestBody Vote vote) {

		voteServ.save(vote);

		return vote;

	}

}
