package com.validate.controller;

import com.validate.model.DemoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wanghongxing on 15/10/10.
 */

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody
    public String index(DemoModel model){

        System.out.println(model.getId());
        System.out.println(model.getName());
        System.out.println(model.getPassword());

        return "ok";
    }


}
