package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;

import java.util.List;

public interface TrackService {
    public void saveTrack(Track track);

    public List<Track> getAllTracks();

    //public Track addNewTrack(Track track);

    public Track updateTrack(Track track);

    public void deleteTrackById(int id);

}
