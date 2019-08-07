package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
 TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {

        this.trackRepository = trackRepository;
    }

  //override the save method from TrackService class and this method save all the tracks
    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);

    }

    //override the getAllTracks method from TrackService class and this method get all the tracks
    @Override
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    //override the Update method from TrackService class and this method update the tracks
    @Override
    public Track updateTrack(int id,Track track) {
        if (trackRepository.existsById(id) == true) {
            return trackRepository.save(track);
        } else {
            return null;
        }
    }
    //override the delete method from TrackService class and this method delete the track by given id
     @Override
     public Track deleteTrackById(int id)
      {
          Optional<Track> track =null;
          if(trackRepository.existsById(id) == true)
          {
              trackRepository.deleteById(id);
              track= trackRepository.findById(id);
          }
          return track.get();
       }
}
