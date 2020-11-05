package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getName() {
        return "김주원";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        if (id == 1) {
            map.put("id", id);
            map.put("name", "김주원");
            map.put("nickname", "Back-End 개발자");
            map.put("created_at", "2020-11-03");
        } else if (id == 2) {
            map.put("id", id);
            map.put("name", "나윤재");
            map.put("nickname", "Android 개발자");
            map.put("created_at", "2020-11-04");
        } else if (id == 3) {
            map.put("id", id);
            map.put("name", "최원빈");
            map.put("nickname", "Front-End 개발자");
            map.put("created_at", "2020-11-05");
        } else {
            map.put("error_message", "요청하신 유저를 찾을 수 없습니다.");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}