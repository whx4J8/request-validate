package com.validate.controller;

import com.validate.model.DemoModel;
import com.validate.validate.annotation.Validate;
import com.validate.validate.process.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.StringReader;

/**
 * Created by wanghongxing on 15/10/10.
 */

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    @Validate
    public String index(Request<DemoModel> req){

        DemoModel model = req.toModel();
        System.out.println(model.getId());
        System.out.println(model.getName());
        System.out.println(model.getPassword());

        return "index";
    }


}
