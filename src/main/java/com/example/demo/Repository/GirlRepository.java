package com.example.demo.Repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by panbingcan on 2017/12/28.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
