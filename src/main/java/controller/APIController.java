package controller;




import hello.UserInfo;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class APIController {

    @RequestMapping("/user")
    public UserInfo user() {
        return new UserInfo(null, null);
    }

  
}