package dta.topcolleguesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dta.topcolleguesbackend.entite.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer>{

	@Query("select v from Vote v where v.id > id")
	List<Vote> findSinceId(@Param("id") int id);
}
