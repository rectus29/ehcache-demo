package com.example.ehcachedemo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RequestedObject {

    private int index = 0;
    private String value;

    public static RequestedObject from(int i){
        return new RequestedObject().setIndex(i).setValue(i+"");
    }
}
