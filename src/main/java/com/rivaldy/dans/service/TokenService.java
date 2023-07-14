package com.rivaldy.dans.service;

import com.rivaldy.dans.entity.Token;
import com.rivaldy.dans.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository repository;

    public Optional<Token> findByToken(String jwt){
        return repository.findByToken(jwt);
    }

    public void saveToken(Token storedToken) {
        repository.save(storedToken);
    }

    public void saveListToken(List<Token> tokens){
        repository.saveAll(tokens);
    }

    public List<Token> findListValidTokenByUser(Long id){
        return repository.findAllValidTokenByUser(id);
    }
}
