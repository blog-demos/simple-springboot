package pers.hai.sample.simplespringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * Create Time: 2019-05-24 15:35
 * Last Modify: 2019-05-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@RestController
@Api(value = "Index测试", tags = "Index")
public class IndexController {

    @ApiOperation(value = "Index测试_value", notes = "Index测试_notes")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没有填好"),
            @ApiResponse(code = 404, message = "请求路径没有找到")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello Spring boot.";
    }
}
