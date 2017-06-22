package pers.tao.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tao on 17-6-21.
 */
@Controller
@RequestMapping(value = "/mvc")
public class ControllerSample {
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public void print(){
        System.out.println("hello controller");
    }
}
