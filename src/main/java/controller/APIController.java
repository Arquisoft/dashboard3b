package controller;


import java.sql.Date;

import javax.servlet.http.HttpSession;

import hello.UserInfo;
import model.Administrador;
import model.Citizen;
import model.exception.BusinessException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.SystemService;
import business.impl.SystemServiceImpl;

@RestController
public class APIController {

    @RequestMapping("/user")
    public UserInfo user() {
        return new UserInfo(null, null);
    }

  
}