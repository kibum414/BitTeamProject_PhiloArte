package shop.parkkibeom.api.crawling.controller;

import shop.parkkibeom.api.crawling.service.CrawlerService;

import java.io.IOException;

public class Crawler {
    public static void main(String[] args) throws IOException {
        CrawlerService crawlerService = new CrawlerService();

        crawlerService.scrapResume();
    }
}
