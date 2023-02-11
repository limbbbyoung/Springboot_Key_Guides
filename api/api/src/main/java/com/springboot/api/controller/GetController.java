package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    // 매개변수가 없는 GET Method
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    // @PathVariable을 활용한 GET Method
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    // @PathVariable 활용시 지정한 변수의 이름과 메서드 매개변수의 이름을
    // 동일하게 맞추기 어려울 때 변수명을 지정해줘야함
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // @RequestParam을 활용한 GET Method
    // @ApiOperation : 대상 API의 설명을 작성하기 위한 어노테이션
    // @ApiParam : 매개변수에 대한 설명 및 설정을 위한 어노테이션.
    // 메서드의 매개변수뿐 아니라 DTO 객체를 매개변수로 사용할 경우 DTO 클래스 내의
    // 매개변수에도 정의할 수 있습니다.
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // @RequestParam과 Map를 조합한 GET method
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // DTO 객체를 활용한 GET Method
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }

}
