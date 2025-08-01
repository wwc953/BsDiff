package org.example.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/test")
    public void test() {

        int i = BsdiffUtils.getInstance().bsdiff("/Users/wangwc/Downloads/ultralytics-8.0.4.zip",
                "/Users/wangwc/Downloads/ultralytics-8.0.4-new.zip",
                "/Users/wangwc/Downloads/ultralytics-8.0.4-patch.patch");
        System.out.printf("----" + i);
    }

    @GetMapping("/bspatch")
    public void bspatch() {
        int i = BsdiffUtils.getInstance().bspatch("/Users/wangwc/Downloads/ultralytics-8.0.4.zip",
                "/Users/wangwc/Downloads/ultralytics-8.0.4-new2222.zip",
                "/Users/wangwc/Downloads/ultralytics-8.0.4-patch.patch");
        System.out.printf("----" + i);
    }

}
