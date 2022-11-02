package net.anyang.test;

import net.anyang.test.properties.ApiProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({
        ApiProperties.class
})
@EnableCaching
public class anyangTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(anyangTestApplication.class, args);
    }
}
