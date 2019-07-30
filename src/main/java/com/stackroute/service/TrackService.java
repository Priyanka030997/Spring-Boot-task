package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException;

    public List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public void deleteTrackById(int id);

}


