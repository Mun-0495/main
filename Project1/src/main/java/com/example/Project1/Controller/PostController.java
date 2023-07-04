package com.example.Project1.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project1.Model.SearchVO;

import java.util.Map;
import java.util.HashMap;


@RestController //Controller임을 알려주는 표시입니다.
@RequestMapping("/api") //API가 불러져 왔을 때 입니다. 즉 api 주소로 받겠다는 의미입니다. localhost:8080/api
public class PostController {

    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod") 
    //이것과 같은 역할을 해 줍니다.
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @PostMapping
    public SearchVO postMethod(@RequestBody SearchVO searchVO) {
        return searchVO;
    }
    // @PostMapping("/post1")
    // public void post1(@RequestBody PostRequestDTO requestData) {
    //     System.out.println(requestData);
    // }
}
    
