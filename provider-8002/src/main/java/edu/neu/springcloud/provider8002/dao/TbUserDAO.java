package edu.neu.springcloud.provider8002.dao;

import edu.neu.springcloud.provider8002.bean.TbUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbUserDAO extends JpaRepository<TbUserEntity, Integer> {

    List<TbUserEntity> findAllByUsername(String username);

}
