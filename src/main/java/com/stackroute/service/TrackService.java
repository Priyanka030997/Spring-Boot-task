package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
     Track saveTrack(Track track) throws TrackAlreadyExistException;

    List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

     Track updateTrack(int id,Track track) throws TrackNotFoundException;

     Track deleteTrackById(int id);

}


