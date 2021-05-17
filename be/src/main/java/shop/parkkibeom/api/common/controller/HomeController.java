package shop.parkkibeom.api.common.controller;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HomeController {

    @GetMapping("/")
    public String init() {

        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

    }
}
