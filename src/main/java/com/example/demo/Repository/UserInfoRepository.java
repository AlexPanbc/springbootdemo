package com.example.demo.Repository;

import com.example.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by panbingcan on 2017/12/29.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {
    List<UserInfo> findByAge(Integer age);

    List<UserInfo> findByCupSize(String cupSize);

    @Query("select o from UserInfo o where o.id=(select max(id) from UserInfo u)")
    UserInfo diyGetUserInfoByMaxId();

    @Query("select o from UserInfo o where o.name like %?1% and o.age>?2")
    List<UserInfo> diyGetUserInfoByNameAndAge(String Name, Integer age);

    /**
     * 映射类查询
     *
     * @param Name
     * @param age
     * @return
     */
    @Query("select o from UserInfo o where o.name like %:name% and o.age>:age")
    List<UserInfo> diyGetUserInfoByNameAndAge2(@Param("name") String Name, @Param("age") Integer age);

    /**
     * 原生态SQL语句查询
     *
     * @return
     */
    @Query(nativeQuery = true, value = "select count(1) from user_info o ")
    Long diyGetUserInfoCount();

}