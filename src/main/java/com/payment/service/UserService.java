package com.payment.service;

import com.payment.domain.user.User;
import com.payment.domain.user.UserType;
import com.payment.dto.UserDTO;
import com.payment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public void validateTransaction(User user, BigDecimal amount) throws Exception {

        if(user.getUserType() == UserType.MERCH) {
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transação");
        }

        if(user.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void saveUser (User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO userDTO) {
        User newUser = new User(userDTO);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
