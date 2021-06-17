package me.geonsu.springdatajpademo2.post;

import me.geonsu.springdatajpademo2.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends MyRepository<Post, Long> {

}
