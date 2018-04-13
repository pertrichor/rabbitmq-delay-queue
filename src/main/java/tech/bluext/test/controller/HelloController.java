package tech.bluext.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：测试控制器
 *
 * @author : blue
 *         Created_Date : 2018-04-12 17:30
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hello There!";
    }
}
