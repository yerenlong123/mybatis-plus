package com.ie.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RedirectController {

    private static Map<String, String> container = new HashMap<>();

    @GetMapping("/{shortLink}")
    public void test(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
        String longLink = container.get(shortLink);
        response.sendRedirect(longLink);
    }

    @GetMapping("longLink2ShortLink")
    @ResponseBody
    public String longLink2ShortLink(@RequestParam String longLink){
        String shortLink = getlinkNo();
        container.put(shortLink, longLink);
        return shortLink;
    }

    public String getlinkNo() {
        String linkNo = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (linkNo.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            linkNo = linkNo + c;
        }
        return linkNo;
    }
}
