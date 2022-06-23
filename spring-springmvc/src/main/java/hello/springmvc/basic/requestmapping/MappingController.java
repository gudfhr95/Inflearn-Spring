package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

  private Logger log = LoggerFactory.getLogger(getClass());

  @RequestMapping("/hello-basic")
  public String helloBasic() {
    log.info("helloBasic");
    return "ok";
  }

  /**
   * 편리한 축약 애노테이션 (코드보기)
   *
   * @GetMapping
   * @PostMapping
   * @PutMapping
   * @DeleteMapping
   * @PatchMapping
   */
  @GetMapping(value = "/mapping-get-v2")
  public String mappingGetV2() {
    log.info("mapping-get-v2");
    return "ok";
  }

  /**
   * PathVariable 사용
   * <p>
   * 변수명이 같으면 생략 가능
   *
   * @PathVariable("userId") String userId -> @PathVariable userId
   */
  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable("userId") String data) {
    log.info("mappingPath userId={}", data);
    return "ok";
  }

  /**
   * PathVariable 사용 다중
   */
  @GetMapping("/mapping/users/{userId}/orders/{orderId}")
  public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
    log.info("mappingPath userId={}, orderId={}", userId, orderId);
    return "ok";
  }

  /**
   * 파라미터로 추가 매핑
   * <p>
   * params="mode",
   * <p>
   * params="!mode"
   * <p>
   * params="mode=debug"
   * <p>
   * params="mode!=debug" (! = )
   * <p>
   * params = {"mode=debug","data=good"}
   */
  @GetMapping(value = "/mapping-param", params = "mode=debug")
  public String mappingParam() {
    log.info("mappingParam");
    return "ok";
  }

  /**
   * 특정 헤더로 추가 매핑
   * <p>
   * headers="mode",
   * <p>
   * headers="!mode"
   * <p>
   * headers="mode=debug"
   * <p>
   * headers="mode!=debug" (! = )
   */
  @GetMapping(value = "/mapping-header", headers = "mode=debug")
  public String mappingHeader() {
    log.info("mappingHeader");
    return "ok";
  }

  /**
   * Content-Type 헤더 기반 추가 매핑 Media Type
   * <p>
   * consumes="application/json"
   * <p>
   * consumes="!application/json"
   * <p>
   * consumes="application/*"
   * <p>
   * consumes="*\/*"
   * <p>
   * MediaType.APPLICATION_JSON_VALUE
   */
  @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String mappingConsumes() {
    log.info("mappingConsumes");
    return "ok";
  }

  /**
   * Accept 헤더 기반 Media Type
   * <p>
   * produces = "text/html"
   * <p>
   * produces = "!text/html"
   * <p>
   * produces = "text/*"
   * <p>
   * produces = "*\/*"
   */
  @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
  public String mappingProduces() {
    log.info("mappingProduces");
    return "ok";
  }
}
