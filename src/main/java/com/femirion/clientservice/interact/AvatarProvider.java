package com.femirion.clientservice.interact;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(name = "avatarprovider", url = "https://google.com/")
public interface AvatarProvider {
    @RequestMapping(method = RequestMethod.GET, value = "/avatars/{userId}", produces = "application/json")
    String getAvatarByUserId(@PathVariable("userId") UUID userId);
}
