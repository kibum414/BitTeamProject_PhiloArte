package shop.parkkibeom.api.crawling.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import shop.parkkibeom.api.art.domain.Art;
import shop.parkkibeom.api.art.repository.ArtRepository;
import shop.parkkibeom.api.category.repository.CategoryRepository;
import shop.parkkibeom.api.crawling.repository.ArtistRepository;
import shop.parkkibeom.api.crawling.repository.ResumeRepository;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SeleniumService {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver"; // 드라이버 경로

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    public void scrapArts() throws IOException {
        String filePath = "/Users/superstar_pkb/project/BitCamp Team Project V2/CrawlingData/Resume.csv";

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.yck.kr/html/contents/magazine01");

        List<Art> list = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".worki_box .tit"));
        List<WebElement> elements2 = driver.findElements(By.cssSelector(".worki_box .sub"));
        List<WebElement> imgUrls = driver.findElements(By.cssSelector(".worki_box img"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            DataOutputStream fw = new DataOutputStream(new FileOutputStream(filePath, true));

            for (int i = 0; i < elements.size(); i++) {

                Art art = Art.builder()
                        .title(elements.get(i).getText())
                        .description(elements2.get(i).getText())
                        .mainImg(imgUrls.get(i).getAttribute("src"))
                        .build();

                System.out.println(art);

                list.add(art);

            }

            if (list.isEmpty()) {
                System.out.println("크롤링 된 값이 없습니다. !");
            } else {
                for (Art a : list) {
                    fw.write(a.toString().getBytes(StandardCharsets.UTF_8));
                }
            }

            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
