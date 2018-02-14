package com.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yakungao
 * @date 2018/2/5
 **/
@Controller
@RequestMapping
public class TestControler {

    @Autowired
    private Product product;

        @RequestMapping(value = "/product")
    @ResponseBody
    public String Product() {
        //for (int i = 0; i < 1; i++) {
        product.sendMessage("Hello, I am amq sender num :4444444444");
        //}
        return "aaa";
    }
}
