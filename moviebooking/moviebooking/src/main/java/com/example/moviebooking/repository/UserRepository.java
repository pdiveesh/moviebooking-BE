package com.example.moviebooking.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.moviebooking.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
