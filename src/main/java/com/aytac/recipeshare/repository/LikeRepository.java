package com.aytac.recipeshare.repository;

import com.aytac.recipeshare.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
