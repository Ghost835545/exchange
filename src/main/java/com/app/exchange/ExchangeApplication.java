package com.app.exchange;

import com.app.exchange.utils.ParseData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ExchangeApplication {
    public static void main(String[] args) {
        ParseData pd = new ParseData();
        pd.parsingData();
        //SpringApplication.run(ExchangeApplication.class, args);
    }

}
