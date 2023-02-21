package com.example.ehcachedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyObjectService {

    private final MyObjectRepository objectRepository;

    @Autowired
    public MyObjectService(MyObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    @Cacheable(cacheNames = "MyObjectCache", condition = "#object.index != 10", key = "#object.getIndex()")
    public String getValueFormObject(RequestedObject object){
        log.debug("pass into method " + object.getValue());
        return this.objectRepository.getObjectValue(object);
    }

    @Cacheable(cacheNames = "MyObjectCache", key = "#object.getIndex()")
    public String getValueFormObjectNoCondition(RequestedObject object){
        log.debug("pass into method " + object.getValue());
        return this.objectRepository.getObjectValue(object);
    }
}
