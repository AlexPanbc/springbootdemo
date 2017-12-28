package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by panbingcan on 2017/12/28.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl ga = new Girl();
        ga.setAge(18);
        ga.setCupSize("D");
        girlRepository.save(ga);


        Girl gb = new Girl();
        gb.setAge(19);
        gb.setCupSize("F");
        girlRepository.save(gb);
    }
}
