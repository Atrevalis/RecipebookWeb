package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import server.entity.Note;
import server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import server.repository.NoteRepository;
import server.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {userRepository.save(user);}
}
