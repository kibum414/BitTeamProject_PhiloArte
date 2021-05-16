package shop.parkkibeom.api.crawling.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Resume {

    private long resumeId;
    private String title;
    private String detail;
    private String coworker;
    private String mainPic;
    private String mainPicTitle;
    private Date mainPicDate;

}
