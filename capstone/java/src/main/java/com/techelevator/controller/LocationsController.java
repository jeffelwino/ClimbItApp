package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.locations.*;
import com.techelevator.model.locations.Area;
import com.techelevator.model.locations.Crag;
import com.techelevator.model.locations.State;
import com.techelevator.model.locations.Wall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
public class LocationsController {

    @Autowired
    private StateDao stateDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WallDao wallDao;
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private CragDao cragDao;



//@PreAuthorize("hasRole('USER')")
@GetMapping(path="/state/")
public List<State> getAllStates(){
    return stateDao.getAllStates();
}

//@PreAuthorize("hasRole('USER')")
@GetMapping(path="/state/{abbrev}")
public State getStateByAbbrev(@PathVariable String abbrev){
    return stateDao.getStateByAbbrev(abbrev);
}

@GetMapping(path="/area/")
public List<Area> getAllAreas(){
    return areaDao.getAllAreas();
}

@GetMapping(path="/area/{id}")
public Area getAreaById(@PathVariable String id){
    return areaDao.getAreaById(id);
}
@ResponseStatus(HttpStatus.CREATED)
@PostMapping(path="/area/{id}")
public Area addArea(@RequestBody Area area){
    return areaDao.addArea(area);
}
@GetMapping(path="/crag/")
public List<Crag> getAllCrags(){
    return cragDao.getAllCrags();
}
@GetMapping(path="/crag/{id}")
    public Crag getCragsById(@PathVariable String id){
    return cragDao.getCragById(id);
}
@PostMapping(path="/crag/{id}")
public Crag addCrag(@RequestBody Crag crag){
    return cragDao.addCrag(crag);
}
@GetMapping(path="/wall/")
    public List<Wall> getAllWalls(){
    return wallDao.getAllWalls();
}
@GetMapping(path="/wall/{id}")
    public Wall getWallById(@PathVariable String id){
    return wallDao.getWallById(id);
}
@PutMapping(path="/wall/{id}")
    public boolean updateWall(@RequestBody Wall wall){
    return wallDao.updateWall(wall);
}


}
