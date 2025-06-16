package it.epicode.u5w3day1PRATICA.Service;

import it.epicode.u5w3day1PRATICA.Dto.UserDto;
import it.epicode.u5w3day1PRATICA.Exception.NotFoundException;
import it.epicode.u5w3day1PRATICA.Model.User;
import it.epicode.u5w3day1PRATICA.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return userRepository.save(user);
    }

    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    public User getUser(int id) throws NotFoundException {
        return userRepository.findById(id).
                orElseThrow(() -> new NotFoundException("User con id " + id + " non trovato"));
    }

    public User updateUser(int id, UserDto userDto) throws NotFoundException {
        User userDaAggiornare = getUser(id);

        userDaAggiornare.setNome(userDto.getNome());
        userDaAggiornare.setCognome(userDto.getCognome());
        userDaAggiornare.setEmail(userDto.getEmail());
        userDaAggiornare.setPassword(userDto.getPassword());

        return userRepository.save(userDaAggiornare);
    }

    public void deleteUser(int id) throws NotFoundException {
        User userDaCancellare = getUser(id);

        userRepository.delete(userDaCancellare);
    }
}