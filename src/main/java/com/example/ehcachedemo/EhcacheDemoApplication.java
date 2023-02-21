package com.example.ehcachedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.metrics.ApplicationStartup;

@Slf4j
@SpringBootApplication
@EnableCaching
public class EhcacheDemoApplication implements ApplicationStartupAware  {

    @Autowired
    private MyObjectService myObjectService;

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("MyObjectCache");
    }

    public static void main(String[] args) {
        SpringApplication.run(EhcacheDemoApplication.class, args);
    }



    @Override
    public void setApplicationStartup(ApplicationStartup applicationStartup) {
        log.debug("request cache");
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));

        log.debug("request cache with condition");
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(10)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObject(RequestedObject.from(10)));
        log.debug(" --- ");
        //this.cacheManager.getCache("MyObjectCache").getNativeCache();
        log.debug(this.myObjectService.getValueFormObjectNoCondition(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObjectNoCondition(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObjectNoCondition(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObjectNoCondition(RequestedObject.from(1)));
        log.debug(this.myObjectService.getValueFormObjectNoCondition(RequestedObject.from(1)));
    }
}
