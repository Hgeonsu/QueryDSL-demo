package me.geonsu.springdatajpademo2.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
//    @Rollback(value = false)
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");

        assertThat(postRepository.contains(post)).isFalse(); //save 전이니까 transient

        postRepository.save(post);

        assertThat(postRepository.contains(post)).isTrue(); // save 이후에는 persistent 상태

        postRepository.delete(post);
        postRepository.flush();
    }
}