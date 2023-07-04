package com.example.Project1.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DeleteController {
    @DeleteMapping("/{id}/delete")
    public String deleteMethod(@PathVariable String id) {
        return "this is delete method";
    }
}
