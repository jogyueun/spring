package com.example.demomvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookReservationController {

    @GetMapping("")
    public String get(@RequestParam("name") String name, @RequestParam("title") String title) {
        return "감사합니다 ["+name+"]님, '["+ title +"]' 도서 예약이 완료되었습니다!";
    }

}
