package me.geonsu.springdatajpademo2.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(T entity); // 이미 구현되어 있지만, custom하게 재정의해서 사용하고 싶은 경우
}
