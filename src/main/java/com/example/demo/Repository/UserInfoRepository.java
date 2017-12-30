package com.example.demo.Repository;

import com.example.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by panbingcan on 2017/12/29.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findByAge(Integer age);

    List<UserInfo> findByCupSize(String cupSize);
}
