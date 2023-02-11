package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // @RequestBody와 Map을 활용한 POST Method
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // DTO 객체를 활용한 POST Method
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
