package shop.parkkibeom.api.crawling.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import shop.parkkibeom.api.crawling.domain.Resume;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CrawlerService {

    public static Document connectUrl(String url) throws IOException {
        return Jsoup
                .connect(url)
                .method(Connection.Method.GET)
                .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute()
                .parse();
    }

    public List<Resume> scrapResume() throws IOException {
        Document document = connectUrl("https://www.wishket.com/partners/#");
        Elements elements = document.select(".partners-unit-username-link");
        String filePath = "/Users/superstar_pkb/project/BitCamp Team Project V2/CrawlingData/Resume.csv";

        System.out.println(document);
        System.out.println(elements.size());

        List<Resume> list = new ArrayList<>();

        System.out.println(document);
        System.out.println(elements.size());

        try {
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"));

            for (int i = 0; i < elements.size(); i++) {
                Resume resume = new Resume();
                resume.setTitle(elements.get(i).text());
                resume.setDetail(elements.get(i).text());
                System.out.println(resume);

                list.add(resume);
            }

            if (list.isEmpty()) {
                System.out.println("크롤링 된 값이 없습니다 !");
            } else {
                for (Resume r : list) {
                    fw.write(r.toString() + ",");
                    fw.newLine();
                }
            }

            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
