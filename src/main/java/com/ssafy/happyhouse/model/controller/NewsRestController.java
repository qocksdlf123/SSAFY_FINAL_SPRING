package com.ssafy.happyhouse.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.News;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class NewsRestController {
	
	@GetMapping("/news")
	public ResponseEntity<Map<String, Object>> crawlNews() {
        try {
            String url = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=260";
            Document document = Jsoup.connect(url).get();

            Elements articleElements = document.select(".list_body.newsflash_body .type06_headline > li > dl");
            log.debug("news size: {}", articleElements.size());
            List<News> news = new ArrayList<News>();
            int i=0; 
            System.out.println("-------------------");
            for (Element element : articleElements) {
            	//String imgSrc = element.select(".photo a img").attr("src");
            	String title;
            	String link;
            	if(element.select("a").size() == 1) {
            		title = element.select("a").text().trim();
            		link = element.select("a").attr("href");
            	}else {
            		title = element.select("a").get(1).text().trim();
            		link = element.select("a").get(1).attr("href");
            	}
                String description = element.select(".lede").text().trim();
                
                news.add(News.builder().imgSrc(getImgSrc(link)).title(title).link(link).description(description).build());
                
                if(++i >= 5) break;
            }
            
            
            
            return handleSuccess(news);
        } catch (IOException e) {
            e.printStackTrace();
            return handleException(e);
        }
    }
	
	// 기사 링크를 통해 들어가서 더 선명한 이미지 주소 얻어오기
	private String getImgSrc(String link) {
		try {
			Document document = Jsoup.connect(link).get();
			
			Elements elements = document.select("#img1");
			
			if(elements.size() == 1) {
				return elements.attr("data-src");
			}else {
				return "#";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "#";
		}
	}
	
	// 작업 성공시 리턴 객체
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	// 작업 실패시 리턴 객체
	private ResponseEntity<Map<String, Object>> handleException(Exception e){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
