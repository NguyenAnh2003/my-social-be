package com.example.newsfeedapi.likes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
    Optional<Like> findByPostIdAndUserId(String postId, String userId);
    Optional<Boolean> existsByPostIdAndUserId(String postId, String userId);
    Optional<List<Like>> findAllByPostId(String postId);
}
