package com.fo.Controller;

import com.fo.entity.version;
import com.fo.service.VersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by jdd on 2018/6/28.
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    @Resource(name = "VersionService")
    private VersionService versionService;

    @RequestMapping("/new")
    @ResponseBody
    public version newversion(Integer type)
    {
        version model=versionService.findByClienttype(type);

        return model;
    }

}