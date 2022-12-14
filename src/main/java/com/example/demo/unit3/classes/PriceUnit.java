package com.example.demo.unit3.classes;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Getter
public class PriceUnit {

    // Locale 클래스 : 지역/언어 등의 정보를 담고있는 클래스이다.
    private final Locale locale;

    public PriceUnit(Locale locale) {
        if (Objects.isNull(locale)) {
            throw new IllegalArgumentException("locale arg is Null");
        }
        this.locale = locale;
    }

    // BicDecimal 클래스 : 숫자, 소수점을 정확하게 표기하도록 해주는 클래스
    // NumberFormat 클래스 : 숫자를 특정 포맷으로 바꿔주는 클래스
    // Optional<T> 클래스 : T 객체의 NullPoint 예외를 처리해주는 클래스
    public String format(BigDecimal price) {
        NumberFormat currencyFormt = NumberFormat.getCurrencyInstance(locale);
        return currencyFormt.format(
                Optional.ofNullable(price).orElse(BigDecimal.ZERO)
        );
    }

    public void validate() {
        if(Objects.isNull(locale))
            throw new IllegalStateException("locale is null");

        log.info("locale is [{}]", locale);
    }

}
