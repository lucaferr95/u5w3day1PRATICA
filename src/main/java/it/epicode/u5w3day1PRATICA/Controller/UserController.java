package it.epicode.u5w3day1PRATICA.Controller;

import it.epicode.u5w3day1PRATICA.Dto.PrenotazioneDto;
import it.epicode.u5w3day1PRATICA.Dto.UserDto;
import it.epicode.u5w3day1PRATICA.Exception.NotFoundException;
import it.epicode.u5w3day1PRATICA.Exception.PrenotazioneGiaEsistenteException;
import it.epicode.u5w3day1PRATICA.Model.Prenotazione;
import it.epicode.u5w3day1PRATICA.Model.User;
import it.epicode.u5w3day1PRATICA.Repository.UserRepository;
import it.epicode.u5w3day1PRATICA.Service.UserService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RequestMapping(path = "/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    //metodo get all

    @GetMapping("")
    public List<User> getAllUser(){
        return   userService.getAllUser();
    }

    //metodo get singolo

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) throws NotFoundException {
        return userService.getUser(id);
    }

    //metodo put

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody @Validated
    UserDto userDto, BindingResult bindingResult)
            throws NotFoundException, ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().
                    stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (e, s) -> e + s));
        }
        return userService.updateUser(id, userDto);
    }
    //metodo delete
    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable int id) throws NotFoundException {
        userService.deleteUser(id);
    }

}


