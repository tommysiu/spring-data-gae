package test.springdata.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.springdata.sample.domain.Parent;
import test.springdata.sample.domain.Player;
import test.springdata.sample.repository.ParentRepository;
import test.springdata.sample.repository.PlayerRepository;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private static Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ParentRepository parentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Player getPlayer(@PathVariable("id") Long id) {
        return playerRepository.findOne(id);
    }

    public Parent getParent() {
        Parent parent;
        List<Parent> parents = parentRepository.findAll();
        if (parents == null || parents.size() == 0) {
            parent = new Parent();
            parentRepository.save(parent);
        } else {
            parent = parents.get(0);
        }

        return parent;
    }

    @RequestMapping(value = "/initDB", method = RequestMethod.GET)
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<String> initDB() {
        // get entity group parent
        Parent p = getParent();

        // insert testing player data
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Snoopy", "9p", p));
        players.add(new Player("Wookstock", "9p", p));
        players.add(new Player("Charlie", "1d", p));
        players.add(new Player("Lucy", "4d", p));
        players.add(new Player("Sally", "5d", p));
        playerRepository.save(players);
        return new ResponseEntity<String>("5 players inserted into database", HttpStatus.OK);
    }
}
