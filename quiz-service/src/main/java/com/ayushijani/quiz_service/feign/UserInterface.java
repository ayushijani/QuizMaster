package com.ayushijani.quiz_service.feign;

import com.ayushijani.quiz_service.model.UserDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserInterface {

    @GetMapping("/users/get/{username}")
    @Headers("X-Internal-Call: true")
    UserDto getUserByUsername(@PathVariable("username") String username);
}
