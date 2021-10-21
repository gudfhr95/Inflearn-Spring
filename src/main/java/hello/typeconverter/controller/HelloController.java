package hello.typeconverter.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

  @GetMapping("/hello-v1")
  public String helloV1(HttpServletRequest request) {
    String data = request.getParameter("data"); // 문자 타입 조회
    Integer intValue = Integer.valueOf(data);
    System.out.println("intValue = " + intValue);
    return "ok";
  }

  @GetMapping("/hello-v2")
  public String helloV2(@RequestParam Integer data) {
    System.out.println("data = " + data);
    return "ok";
  }
}
