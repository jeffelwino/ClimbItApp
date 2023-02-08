package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.locations.*;
import com.techelevator.model.locations.*;
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
    @GetMapping(path="/state")
    public List<State> getAllStates(){
        return stateDao.getAllStates();
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping(path="/state/{abbrev}")
    public State getStateByAbbrev(@PathVariable String abbrev){
        return stateDao.getStateByAbbrev(abbrev);
    }

    @GetMapping(path="/area")
    public List<Area> getAllAreas(){
        return areaDao.getAllAreas();
    }

    @GetMapping(path="/area/state/{abbrev}")
    public List<Area> getAreasByStateAbbrev(@PathVariable String abbrev){
        return areaDao.getAreasByState(abbrev);
    }

    @GetMapping(path="/area/{id}")
    public Area getAreaById(@PathVariable String id){
        return areaDao.getAreaById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/area/create")
    public Area addArea(@RequestBody Area area){
        return areaDao.addArea(area);
    }

    @PutMapping(path="/area")
    public boolean updateArea(@RequestBody Area area){
        return areaDao.updateArea(area);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/area/{id}")
    public boolean deleteArea(@RequestBody String id){
        return areaDao.deleteArea(id);
    }

    @GetMapping(path="/crag")
    public List<Crag> getAllCrags(){
        return cragDao.getAllCrags();
    }

    @GetMapping(path="/crag/area/{id}")
    public List<Crag> getCragsByAreaId(@PathVariable String id){
        return cragDao.getCragsByAreaId(id);
    }

    @GetMapping(path="/crag/{id}")
        public Crag getCragsById(@PathVariable String id){
        return cragDao.getCragById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/crag/create")
    public Crag addCrag(@RequestBody Crag crag){
        return cragDao.addCrag(crag);
    }

    @PutMapping(path="/crag")
    public boolean updateCrag(@RequestBody Crag crag){
        return cragDao.updateCrag(crag);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/crag/{id}")
    public boolean deleteCrag(@RequestBody String id){
        return cragDao.deleteCrag(id);
    }

    @GetMapping(path="/wall")

    public List<Wall> getAllWalls(){
        return wallDao.getAllWalls();
    }

    @GetMapping(path="/wall/crag/{id}")
    List<Wall> getWallsByCragId(@PathVariable String id){
        return  wallDao.getWallsByCragId(id);
    }

    @GetMapping(path="/wall/{id}")
    public Wall getWallById(@PathVariable String id){
    return wallDao.getWallById(id);
}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/wall/create")
    public Wall addWall(@RequestBody Wall wall){
        return wallDao.addWall(wall);
    }

    @PutMapping(path="/wall")
        public boolean updateWall(@RequestBody Wall wall){
        return wallDao.updateWall(wall);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/wall/{id}")
        public boolean deleteWall(@RequestBody String id){
        return wallDao.deleteWall(id);
    }

    @GetMapping(path="/route")
        public List<Route> getAllRoutes(){
        return routeDao.getAllRoutes();
    }

    @GetMapping(path="/route/wall/{id}")
    public List<Route> getRoutesByWallId(@PathVariable String id){
        return routeDao.getRouteByWallId(id);
    }

    @GetMapping(path="/route/{id}")
        public Route getRouteById(@PathVariable String id){
        return routeDao.getRouteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/route/create")
        public Route addRoute(@RequestBody Route route){
        return routeDao.addRoute(route);
    }

    @PutMapping(path="/route")
        public boolean updateRoute(@RequestBody Route route){
        return routeDao.updateRoute(route);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/route/{id}")
    public boolean deleteRoute(@RequestBody String id){
        return routeDao.deleteRoute(id);
    }
    
}
