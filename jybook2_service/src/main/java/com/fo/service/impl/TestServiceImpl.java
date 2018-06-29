package com.fo.service.impl;

import com.fo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by jdd on 2018/6/27.
 */
@Service("TestService")
public class TestServiceImpl implements TestService {
    public String test() {
        return "test";
    }
}
