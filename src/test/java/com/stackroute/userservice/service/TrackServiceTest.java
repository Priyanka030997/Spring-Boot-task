package com.stackroute.userservice.service;

import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.userservice.domain.Track;
import com.stackroute.userservice.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrackServiceTest {
    Track track=new Track();

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        //track = new Track();
        track.setId(131);
        track.setName("dfsf");
        track.setComment("ghdbcsd");
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        //verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/
    }

    @Test
    public void getAllTrack(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);
    }

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public static class TrackserviceApplicationTests {

        @Test
        public void contextLoads() {
        }

    }
}

