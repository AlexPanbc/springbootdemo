package com.example.demo.Repository;

import com.example.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by panbingcan on 2017/12/29.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> ,JpaSpecificationExecutor<UserInfo> {
    List<UserInfo> findByAge(Integer age);

    List<UserInfo> findByCupSize(String cupSize);
}
