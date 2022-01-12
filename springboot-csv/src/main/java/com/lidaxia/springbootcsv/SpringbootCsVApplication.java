package com.lidaxia.springbootcsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lidaxia
 * @desc
 * @date 2021/11/5 17:29（
 */
@RestController
@SpringBootApplication
public class SpringbootCsVApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCsVApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "欢迎访问 springboot-csv";
    }

    /** 导出excel */
    @GetMapping("/excel")
    @ResponseBody
    Object getExcelFile(HttpServletResponse res) throws Exception {
        try {
            List<Test> items = new ArrayList<>();
            items.add(new Test("11111", "222"));
            items.add(new Test("123", "4444"));
            CsvHelper.writeCsv(items, res.getOutputStream(), res, null);
        } catch (IOException e) {
            return "error";
        }
        return null;
    }
}
