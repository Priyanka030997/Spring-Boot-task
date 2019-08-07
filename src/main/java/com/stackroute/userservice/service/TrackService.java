package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrackService {
    void saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

     Track updateTrack(int id,Track track) throws TrackNotFoundException;

    Track void deleteTrackById(int id);

     List<Track> trackByName(String name);
     Track trackById(int id) throws TrackNotFoundException;
     void getUrlData() throws Exception;
}
