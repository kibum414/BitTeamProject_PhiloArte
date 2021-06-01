package shop.parkkibeom.api.crawling.controller;

import shop.parkkibeom.api.crawling.service.SeleniumService;

import java.io.IOException;

public class Selenium {
    public static void main(String[] args) throws IOException {
        SeleniumService seleniumService = new SeleniumService();

        seleniumService.scrapArts();
    }
}
