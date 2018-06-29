package com.fo.service.impl;

import com.fo.entity.Person;
import com.fo.repository.PersonRepository;
import com.fo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdd on 2018/6/27.
 */
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Long savePerson() {
        Person person = new Person();
        person.setUsername("afeng");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is afeng");
        return personRepository.save(person);
//        return Long.parseLong("123");
    }
}
