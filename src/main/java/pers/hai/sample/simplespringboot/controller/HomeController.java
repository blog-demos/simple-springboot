package pers.hai.sample.simplespringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-24 14:32
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@RestController
@Api(value = "Home测试", tags = "Home")
@RequestMapping(value = "/home")
public class HomeController {

    @ApiOperation(value = "page1", notes = "Home Page1测试_notes")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径没有找到")
    })
    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String page1() {
        return "Spring boot Home page1.";
    }

    @ApiOperation(value = "getSession", notes = "Home Page2测试_notes")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径没有找到")
    })
    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public String getSession(HttpSession session) {
        return session.getId();
    }

    @ApiOperation(value = "setCookies", notes = "Home Page3测试_notes")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径没有找到")
    })
    @RequestMapping(value = "/page3", method = RequestMethod.GET)
    public String setCookies(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("cookie-key_1", "cookie-value_1");
        Cookie cookie2 = new Cookie("cookie-key_2", "49c03cd2-1825-4bbf-9b78-e369b5e7b002");

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        return "获得cookies信息成功";
    }

    @ApiOperation(value = "getCookies", notes = "Home Page4测试_notes")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径没有找到")
    })
    @RequestMapping(value = "/page4", method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies)
            return "未获取到Cookies";

        StringBuilder sb = new StringBuilder();
        for (Cookie cookie : cookies) {
            sb.append(String.format("%s=%s\n", cookie.getName(), cookie.getValue()));
        }

        return sb.toString();
    }
}
