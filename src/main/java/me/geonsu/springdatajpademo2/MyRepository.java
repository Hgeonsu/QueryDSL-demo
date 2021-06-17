package me.geonsu.springdatajpademo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    // 어떤 entity가 persistent 상태에 들어있는지 확인하는
    boolean contains(T entity);
}
