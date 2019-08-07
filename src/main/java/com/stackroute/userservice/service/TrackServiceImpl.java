package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
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
    @Override
    public void saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException();
        }
        Track savedtrack=trackRepository.save(track);
        if(savedtrack==null) {
            throw new TrackAlreadyExistsException();
        }

    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
//    @Override
//    public Track addNewTrack(Track track)
//    {
//        return trackRepository.save(track);
//    }
    @Override
    public Track updateTrack(int id,Track track) throws TrackNotFoundException
    {
        if(trackRepository.existsById(track.getId())) {
            Track track1 = trackRepository.findById(track.getId()).get();
            track1.setComment(track.getComment());
            trackRepository.save(track1);
            return track1;
        }
        else
        {
        throw new TrackNotFoundException();
    }

        //return trackRepository.save(track);
    }
     @Override
     public void deleteTrackById(int id)
      {
        trackRepository.deleteById(id);
       }
    @Override
    public List<Track> trackByName(String name) {
        return trackRepository.trackByName(name);
    }
}
