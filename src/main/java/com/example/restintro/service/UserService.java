package com.example.restintro.service;

import com.example.restintro.model.UserEntity;
import com.example.restintro.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements InterfaceUserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public Set<UserEntity> findAll() {
        Set<UserEntity> set = new HashSet<>();
        repo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public UserEntity save(UserEntity object) {
        UserEntity user = (UserEntity) object;
        return repo.save(user);
    }

    @Override
    public void delete(UserEntity user) {

        repo.delete(user);
    }

    @Override
    public void deleteById(Long aLong) {
        repo.deleteById(aLong);
    }

    @Override
    public Optional<UserEntity> findById(Long aLong) {
        return Optional.empty();
    }
}

