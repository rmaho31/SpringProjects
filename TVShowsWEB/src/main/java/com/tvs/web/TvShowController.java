package com.tvs.web;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tvs.business.TvShow;
import com.tvs.business.TvShowRepository;

@Controller   
@RequestMapping(path="/TvShows") 
public class TvShowController {
	@Autowired 
	private TvShowRepository tvShowRepository;

	@PostMapping(path="/Add") 
	public @ResponseBody String addNewTvShow (@RequestBody TvShow tv) {
				tvShowRepository.save(tv);
		return "Saved";
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody TvShow getTvShow(@RequestParam int id) {
			return tvShowRepository.findById(id).get();
	}

	@GetMapping(path="/List")
	public @ResponseBody Iterable<TvShow> getAllTvShows() {
		return tvShowRepository.findAll();
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody String deleteTvShow(@RequestParam int id) {
		try {
			tvShowRepository.delete(tvShowRepository.findById(id).get());			
		} catch(IllegalArgumentException | NoSuchElementException e) {
			e.printStackTrace();
			return "Error Deleting";
		}
		return "Deleted";
	}
	
	@PostMapping(path="/Change") 
	public @ResponseBody String updateTvShow (@RequestBody TvShow tv) {
			tvShowRepository.save(tv);
			return "Updated";
	}
}