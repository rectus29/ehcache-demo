package com.example.ehcachedemo;

import org.springframework.stereotype.Repository;

@Repository
public class MyObjectRepository {

    public String getObjectValue(RequestedObject requestedObject) {
        return requestedObject.getValue();
    }
}
