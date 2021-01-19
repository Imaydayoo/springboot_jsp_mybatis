package com.hang.springboot_end.controlller;

import com.hang.springboot_end.domain.Books;
import com.hang.springboot_end.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping("/test")
    public List<Books> queryAllBook(Model model) {
        List<Books> list = bookService.queryAllBook();

        return list;
    }

    @RequestMapping("/hello")
    public String hello() {
        //m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "index";
    }


}
