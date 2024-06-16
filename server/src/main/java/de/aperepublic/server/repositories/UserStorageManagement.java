package de.aperepublic.server.repositories;

import de.aperepublic.server.Entity.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

//@Service
//public class UserStorageManagement implements UserRepository {
//
//    private List<Users> userList;
//
//    public UserStorageManagement() {
//        Users user = new Users();
//        user.username = "enexhd";
//        user.email = ("enexhd@gmail.com");
//        user.firstname = ("Marc");
//        user.lastname = ("Schillinger");
//        user.password = ("123");
//        user.birthday = new Date(2001, 9, 11);
//        userList = List.of(user);
//    }
//
//    @Override
//    public Optional<de.aperepublic.server.Entity.Users> findByUsername(String username) {
//        return userList.stream().filter(u -> u.username.contentEquals(username)).findFirst();
//    }
//
//    @Override
//    public Optional<de.aperepublic.server.Entity.Users> findByEmail(String email) {
//        return userList.stream().filter(u -> u.email.contentEquals(email)).findFirst();
//    }
//
//    @Override
//    public Boolean existsByUsername(String username) {
//        return userList.stream().anyMatch(u -> u.username.contentEquals(username));
//    }
//
//    @Override
//    public Boolean existsByEmail(String email) {
//        return userList.stream().anyMatch(u -> u.email.contentEquals(email));
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Users> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Users> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Users getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Users getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public Users getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Users> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Users> List<S> findAll(Example<S> example) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Users> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Users> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends Users, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public Users save(Users user) {
//        userList.add(user);
//        return user;
//    }
//
//    @Override
//    public <S extends Users> List<S> saveAll(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Users> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public List<Users> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<Users> findAllById(Iterable<Long> longs) {
//        return List.of();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Users entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Users> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<Users> findAll(Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public Page<Users> findAll(Pageable pageable) {
//        return null;
//    }
//}
