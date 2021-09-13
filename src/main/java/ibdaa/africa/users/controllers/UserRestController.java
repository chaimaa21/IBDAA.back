package ibdaa.africa.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ibdaa.africa.users.entities.User;
import ibdaa.africa.users.repositories.UserRepository;

@RestController
@CrossOrigin(origins="*")
public class UserRestController {
@Autowired
UserRepository userRep;


@RequestMapping(value ="/login/{username}",method = RequestMethod.GET)

public User getUserByUsernamePassword(@PathVariable("username") String
username) {
return userRep.findByUsername(username);
}
}