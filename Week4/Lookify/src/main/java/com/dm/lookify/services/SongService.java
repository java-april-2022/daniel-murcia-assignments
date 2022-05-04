package com.dm.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.lookify.models.Song;
import com.dm.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	

	 // returns all the expenses
	 public List<Song> allSongs() {
	     return songRepository.findAll();
	 }
	 
	 // creates an expense
	 public Song createSong(Song s) {
	     return songRepository.save(s);
	 }
	 
	 // retrieves an expense
	 public Song findSong(Long id) {
	     Optional<Song> optionalSong = songRepository.findById(id);
	     if(optionalSong.isPresent()) {
	         return optionalSong.get();
	     } else {
	         return null;
	     }
	 }
	 
	 //updates the expense 
	 public Song updateSong(Song s) {
	     return songRepository.save(s);
	 }
	 
	 //Get Expense Details 
	public Song songDetails(Long id) {
		return songRepository.findById(id).orElse(null);
	}
	
	//must pass in ID to delete art by id 
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	

}
