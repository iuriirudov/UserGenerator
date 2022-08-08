package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @GetMapping("/dummy")
    public ResponseEntity<List<User>> createUsers(
            @RequestParam(value = "create", defaultValue = "1") int num) {

        for (int i = 0; i < num; i++) {
            users.add(new DummyUser().createDummyUser());
        }

        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers (
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "limit", defaultValue = "10") int itemsPerPage
    ) {

        if (users.size() == 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<User> response = new UserAccessor().getUsers(users, pageNumber, itemsPerPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(
            value = "/{userId}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<User> getUser(@PathVariable String userId) {

        User user = null;
        for (User e : users) {
            if (e.getId().toString().equals(userId)) {
                user = e;
                break;
            }
        }

        if (user == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User newUser = new UserBuilder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setDob(user.getDob())
                .createUser();

        users.add(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping
    public String updateUser() {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }
}
