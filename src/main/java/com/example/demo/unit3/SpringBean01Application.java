package com.example.demo.unit3;

import com.example.demo.DemoApplication;
import com.example.demo.unit3.classes.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Locale;

@SpringBootApplication
@Slf4j
public class SpringBean01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        PriceUnit defaultPriceUnit = ctx.getBean("priceUnit", PriceUnit.class);
        log.info("Price #1 : {}", defaultPriceUnit.format(BigDecimal.valueOf(10.2)));

        PriceUnit wonPriceUnit = ctx.getBean("wonPriceUnit", PriceUnit.class);
        log.info("Price #2 : {}", wonPriceUnit.format(BigDecimal.valueOf(1000)));
    }

    // Locale이 US로 초기화된 PriceUnit 빈 생성, Bean 이름은 priceUnit이다.
    @Bean(name = "priceUnit")
    public PriceUnit dollarPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    // Locale이 KOREA로 초기화된 PriceUnit 빈 생성, Bean 이름을 설정하지 않으면 메소드 이름으로 지정된다.
    @Bean
    public PriceUnit wonPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }
}
