package pers.hai.sample.simplespringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-24 14:32
 * Last Modify: 2019-05-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/home")
    public String home() {
        return "Spring boot Home page.";
    }
}
