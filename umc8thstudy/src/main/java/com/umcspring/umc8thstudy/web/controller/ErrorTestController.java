package com.umcspring.umc8thstudy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {
    @GetMapping("/test/500")
    public String errorTest() {
        throw new RuntimeException("테스트용 예외 발생!");
    }
}
