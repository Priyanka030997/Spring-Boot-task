package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public void saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

    public Track updateTrack(Track track) throws TrackNotFoundException;

    public void deleteTrackById(int id);

    public List<Track> trackByName(String name);

}
