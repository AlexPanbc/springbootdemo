package com.example.demo.Controller;

import com.example.demo.Repository.GirlRepository;
import com.example.demo.Service.GirlService;
import com.example.demo.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by panbingcan on 2017/12/28.
 */
@RequestMapping(value = "girl")
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 返回列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加操作
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "add")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/get/{id}")
    public Girl Get(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     * body提交需要选择 raw 后面是application/json
     * @return
     */
//    @PutMapping(value = "/update/{id}")
//    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
    @PutMapping(value = "/update")
    public Girl girlUpdate(@RequestBody Girl girl) {
        return girlRepository.save(girl);
    }

    @PutMapping(value = "/update/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl g = new Girl();
        g.setId(id);
        g.setCupSize(cupSize);
        g.setAge(age);
        return girlRepository.save(g);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void Delete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查找
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/get/age/{age}")
    public List<Girl> GirlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "two")
    public void GirlTwo() {
        girlService.insertTwo();
    }
}
