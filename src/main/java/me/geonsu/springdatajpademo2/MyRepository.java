package me.geonsu.springdatajpademo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/*
중간에 들어가는 interface들은.. JpaRepository 상속하면 <T, ID extends Serializable> 타입의 bean을 만들려고 하는데
이걸 만들지 않게 하는 역할?
 */
@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
// JpaRepository를 그대로 쓰지 않고, 상속 받아서 기능을 추가해서 MyRepository라는 걸 만들어서 사용
    // 어떤 entity가 persistent 상태에 들어있는지 확인하는
    boolean contains(T entity);
}
