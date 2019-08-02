package com.stackroute.userservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import com.stackroute.userservice.repository.TrackRepository;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.springframework.http.HttpHeaders.USER_AGENT;


//import static jdk.internal.net.http.HttpRequestImpl.USER_AGENT;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    @Override
    public void saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException();
        }
        Track savedtrack = trackRepository.save(track);
        if (savedtrack == null) {
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
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if (trackRepository.existsById(track.getId())) {
            Track track1 = trackRepository.findById(track.getId()).get();
            track1.setComment(track.getComment());
            trackRepository.save(track1);
            return track1;
        } else {
            throw new TrackNotFoundException();
        }

        //return trackRepository.save(track);
    }

    @Override
    public void deleteTrackById(int id) {

        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> trackByName(String name) {

        return trackRepository.trackByName(name);
    }
    @Override
    public Track trackById(int id) throws TrackNotFoundException {
        //check if track exists
        if (!trackRepository.existsById(id)) {
            //throw custom exception
            throw new TrackNotFoundException();
        }
        //otherwise get the track
        return trackRepository.findById(id).orElse(null);
    }

    @Override
    public void getUrlData() throws Exception {
        String url = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=60318cf025cbe9289ee3d0b42692abc2&format=json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);


        //Object Mapper to access the JSON from the response entity
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;

        //read the response body to get JSON object
        try {
            root = mapper.readTree(result.getBody());
            ArrayNode arrayNode = (ArrayNode) root.path("tracks").path("track");

            //iterate the JSON array
            for (int i = 0; i < arrayNode.size(); i++) {
                //get a new Track object and fill it with data using setters
                Track track = new Track();
                track.setName(arrayNode.get(i).path("name").asText());
                track.setComment(arrayNode.get(i).path("artist").path("name").asText());
                //save the track to database
                trackRepository.save(track);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
