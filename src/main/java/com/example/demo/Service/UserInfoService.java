package com.example.demo.Service;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.domain.Entity.UserInfoEntityPage;
import com.example.demo.domain.UserInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.execption.UserInfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedArray;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * Created by Alex on 2017/12/30.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    private final static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    /**
     * 根据查询数据的年龄输出提示信息 属于系统提示不属于错误
     *
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception {
        UserInfo userInfo = userInfoRepository.findOne(id);
        Integer age = userInfo.getAge();
        if (age <= 20)
            throw new UserInfoException(ResultEnum.PRIMARY_SCHOOL);
        if (age > 20 && age < 30)
            throw new UserInfoException(ResultEnum.Middle_SCHOOL);
        if (age >= 30)
            throw new UserInfoException(ResultEnum.SUCCESS);
        if (age > 100)
            throw new UserInfoException(ResultEnum.UNKONW_ERROR);
    }

    /**
     * 批量添加用户数据
     *
     * @throws Exception
     */
    public void addList() throws Exception {
        List<UserInfo> lstu = new ArrayList<>();
        UserInfo u;
        String[] cup = {"B", "C", "D", "E", "F"};
        for (int i = 18; i < 118; i++) {
            logger.info(cup[i % 5] + i);
            u = new UserInfo();
            u.setAge(i);
            u.setCupSize(cup[i % 5]);
            u.setCreateTime(new Date());
            u.setHeight(i);
            u.setWeight(i);
            u.setName("test" + i);
            u.setImg("http://www.baidu.com");
            lstu.add(u);
        }
        userInfoRepository.save(lstu);
    }

    /**
     * 分页方法
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    public Page<UserInfo> getPageing(Integer page, Integer size) throws Exception {
        return userInfoRepository.findAll(new PageRequest(page, size, Sort.Direction.ASC, "id"));
    }

    /**
     * 多条件查询
     *
     * @param page
     * @param size
     * @param age
     * @param cupSize
     * @return
     * @throws Exception
     */
    public Page<UserInfo> getPageSort(Integer page, Integer size, Integer age, String cupSize) throws Exception {
// 另一种写法
//        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
//        Page<Book> bookPage = bookRepository.findAll(new Specification<Book>(){
//            @Override
//            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                Predicate p1 = criteriaBuilder.equal(root.get("name").as(String.class), bookQuery.getName());
//                Predicate p2 = criteriaBuilder.equal(root.get("isbn").as(String.class), bookQuery.getIsbn());
//                Predicate p3 = criteriaBuilder.equal(root.get("author").as(String.class), bookQuery.getAuthor());
//                query.where(criteriaBuilder.and(p1,p2,p3));
//                return query.getRestriction();
//            }
//        },pageable);
//        return bookPage;
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                list.add(criteriaBuilder.equal(root.get("cupSize").as(String.class), cupSize));
                list.add(criteriaBuilder.gt(root.get("age").as(Integer.class), age));//gt大于
                Predicate[] predicate = new Predicate[list.size()];
//                return criteriaBuilder.gt(root.get("age"), age);
                return criteriaBuilder.and(list.toArray(predicate));
            }
        };
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return userInfoRepository.findAll(specification, pageable);
    }

    /**
     * 根据实体参数获取数据
     *
     * @param page
     * @param size
     * @param userInfoEntityPage
     * @return
     */
    public Page<UserInfo> getPageParam(Integer page, Integer size, UserInfoEntityPage userInfoEntityPage) throws Exception {
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                list.add(criteriaBuilder.equal(root.get("cupSize").as(String.class), userInfoEntityPage.getCupSize()));
                list.add(criteriaBuilder.gt(root.get("age").as(Integer.class), userInfoEntityPage.getAge()));//gt大于
                list.add(criteriaBuilder.like(root.get("name").as(String.class), "%" + userInfoEntityPage.getName() + "%"));
                Predicate[] predicate = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(predicate));
//                Predicate p1 = criteriaBuilder.equal(root.get("cupSize").as(String.class), userInfoEntityPage.getCupSize());
//                Predicate p2 = criteriaBuilder.gt(root.get("age").as(Integer.class), userInfoEntityPage.getAge());
//                Predicate p3 = criteriaBuilder.like(root.get("name").as(String.class), "%" + userInfoEntityPage.getName() + "%");
//                criteriaQuery.where(criteriaBuilder.and(p1, p2), criteriaBuilder.or(p3));
//                return criteriaQuery.getRestriction();
            }
        };
        return userInfoRepository.findAll(specification, new PageRequest(page, size, Sort.Direction.DESC, "id"));
    }

}
