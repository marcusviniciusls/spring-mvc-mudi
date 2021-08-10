package br.com.alura.mudi_springmvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("nome","Mundo");
        return "hello";
    }
}
