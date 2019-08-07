package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
@Api
public class TrackController {
    @Autowired
    TrackService trackService;

    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })


     @PostMapping(value="/save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try{
      // calls saveTrack() from service
            responseEntity = new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.CREATED);
        } catch (Exception e){
            responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @ApiOperation(value = "Get all the tracks")
    @GetMapping(value="/track")
    public ResponseEntity<?> getAllTracks()
    {
      return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @ApiOperation(value = "Update track")
    @PostMapping(value="/update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;
        try{
     //	calls updateTrack() from service
            responseEntity = new ResponseEntity<Track>(trackService.updateTrack(id,track), HttpStatus.OK);
        } catch (Exception e){
            responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    
    @ApiOperation(value = "Delete track")
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try
        {
        responseEntity=new ResponseEntity<Track>(trackService.deleteTrackById(id), HttpStatus.CREATED);
    }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @ApiOperation(value = "TrackByName")
    @GetMapping(value="/trackbyname/{name}")
    public ResponseEntity<?> trackByName(@PathVariable("name") String name)
    {
        ResponseEntity responseEntity;
        try
        {
            trackService.trackByName(name);
            responseEntity=new ResponseEntity<String>("sucessfully trackByName", HttpStatus.CREATED);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
