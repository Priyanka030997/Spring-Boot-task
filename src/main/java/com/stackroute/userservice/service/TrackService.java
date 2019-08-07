package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    void saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> getAllTracks();
    
     Track updateTrack(int id,Track track) throws TrackNotFoundException;

    void deleteTrackById(int id);
  

    List<Track> trackByName(String name);

}
