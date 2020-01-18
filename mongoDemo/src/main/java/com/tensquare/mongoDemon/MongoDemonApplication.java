package com.tensquare.mongoDemon;

import com.tensquare.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemonApplication.class);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }

}
