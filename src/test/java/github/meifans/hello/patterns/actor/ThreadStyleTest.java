package github.meifans.hello.patterns.actor;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Meifans on 17/3/1.
 */
@Slf4j
public class ThreadStyleTest {

  private final String question = "s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%E8%B0%81%E6%9C%80%E5%B1%8C&rsv_pq=ef753fe00001e72a&rsv_t=2209NeUXdF3OS5oN%2BLX1C2xp4g%2BoaNa8mmO%2F%2B1fkrwM9GDloqqk%2FyTBnoeo&rqlang=cn&rsv_enter=1&rsv_sug3=14&rsv_sug1=12&rsv_sug7=100&rsv_sug2=0&inputT=4110&rsv_sug4=4549";
  private final List<String> engines = Collections.singletonList("https://www.baidu.com/");

  @Test
  public void testOriginalThread() {
    String result = ThreadStyle.getResult(question, engines);
    log.info("original:{}", result);
    Assert.assertTrue(StringUtils.hasText(result));
  }

  @Test
  public void testExecutors() {
    String result = ThreadStyle.getResultFromExecutors(question, engines);
    log.info("executors:{}", result);
    Assert.assertTrue(StringUtils.hasText(result));

  }

  @Test
  public void testParallel() {
    String result = ThreadStyle.getResultFromParallel(question, engines);
    log.info("parallel:{}", result);
    Assert.assertTrue(StringUtils.hasText(result));
  }

  @Test
  public void testActor() {
    String result = ThreadStyle.getResultActors(question, engines);
    log.info("actor:{}", result);
    Assert.assertTrue(StringUtils.hasText(result));
  }


}