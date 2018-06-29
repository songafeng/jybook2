package com.fo.Controller;

import com.fo.entity.image;
import com.fo.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jdd on 2018/6/28.
 */
@Controller
@RequestMapping("/image")
public class ImageController {
    @Resource(name = "ImageService")
    private ImageService imageService;

    @RequestMapping("/single")
    @ResponseBody
    public image single(String place)
    {
        place=place==null||place==""?"index":place;
        image model=imageService.findSingleByPlace(place);
        return model;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<image> list(String place)
    {
        place=place==null||place==""?"ad":place;
        List<image> list=imageService.findByPlace(place);
        return list;
    }
}
