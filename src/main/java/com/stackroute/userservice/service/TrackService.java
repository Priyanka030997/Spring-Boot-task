package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;

import java.util.List;

public interface TrackService {
   Track saveTrack(Track track);

     List<Track> getAllTracks();

     Track updateTrack(int id,Track track);

     Track deleteTrackById(int id);

}
