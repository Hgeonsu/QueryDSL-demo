package me.geonsu.springdatajpademo2.post;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// slicing test가 뭔지
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
//    @Rollback(value = false)
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post);

        Predicate predicate = QPost.post.title.containsIgnoreCase("hi");
        Optional<Post> one = postRepository.findOne(predicate); // findOne을 사용한 결과는 Optional로 나온다
        boolean contains = postRepository.contains(post);

        assertTrue(contains);
        //assertThat(one).isNotEmpty();
        assertTrue(one.isPresent()); // 위와 같은 동작
    }
}