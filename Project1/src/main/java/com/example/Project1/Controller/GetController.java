package com.example.Project1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Model.SearchVO;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class GetController {
    @RequestMapping(method=RequestMethod.GET, path = "/getRequest")
    public String getRequest() {
        return "this is getRequest";
    }
    /*public String requestMethodName(@RequestParam String param) {
        return param;
    }*/

    @GetMapping("/getParameters")
    public String getParamters(@RequestParam String id, @RequestParam String email) {
        return id + email;
    }

    @GetMapping("/getMultiParameters") 
    public String getMultiParameters(SearchVO searchVO) {
        return searchVO.getid() + searchVO.getEmail();
    }

    @GetMapping("/getParametersWithJson")
    public SearchVO getParametersWithJson(SearchVO searchVO) {
        return searchVO;
    }
    
}
