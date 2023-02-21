package com.example.ehcachedemo.controller;

import com.example.ehcachedemo.MyObjectService;
import com.example.ehcachedemo.RequestedObject;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyObjectController {

    private MyObjectService myObjectService;
    private CacheManager cacheManager;

    public MyObjectController(MyObjectService myObjectService, CacheManager cacheManager) {
        this.myObjectService = myObjectService;
        this.cacheManager = cacheManager;
    }

    @GetMapping(path = "yolo")
    public ResponseEntity<String> getAll(@RequestParam("id") Integer id){
        this.cacheManager.getCacheNames();
        return ResponseEntity.ok(this.myObjectService.getValueFormObject(RequestedObject.from(id)));
    }
}
