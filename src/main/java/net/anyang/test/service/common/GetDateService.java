package net.anyang.test.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@Service
public class GetDateService {

    public String getBeforeMonth() {
        LocalDate now = LocalDate.now().minusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return now.format(formatter);
    }

    public String getYesterday() {
        LocalDate now = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);
    }

    public String getNowMonth() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        return now.format(formatter);
    }

    public String getNowDay() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);
    }

    public String getlastYear() {
        LocalDate now = LocalDate.now().minusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return now.format(formatter);
    }

    public String getNowTime(){
        LocalDateTime now =  LocalDateTime.now();
        int minute = now.getMinute();
        if(minute < 30){
            now =  LocalDateTime.now().minusMinutes(minute+20);
        }
        else{
            now = LocalDateTime.now();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        return now.format(formatter);
    }

    public int getNowDayInt() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String StringNow = now.format(formatter);
        return Integer.parseInt(StringNow);
    }
}


