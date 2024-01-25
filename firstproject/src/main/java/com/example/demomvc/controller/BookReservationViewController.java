package com.example.demomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookReservationViewController {

    @GetMapping("/book-reservation")
    public String getBookReservationView() {
        return "bookReservationForm.html";
    }

    @PostMapping("/book-reservation")
    @ResponseBody
    public String postBookReservation(@RequestParam("name") String name, @RequestParam("title") String title) {
        return "감사합니다 ["+name+"]님, '["+ title +"]' 도서 예약이 완료되었습니다!";
    }

}
