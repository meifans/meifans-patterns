package github.meifans.hello.patterns.actor;


import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Meifans on 17/2/28.
 */
public class ThreadStyle {


  /**
   * a simple task to show original use of thread.
   * multi-thread run,communicate by Variable Shared.
   */
  private static String getResult(String question, List<String> engines) {
    AtomicReference<String> result = new AtomicReference<>();
    engines.forEach(r -> {
      String url = r + question;
      new Thread(() -> result.compareAndSet(null, responseFrom(url)));
    });
    while (result.get() == null) ;
    return result.get();
  }

  /**
   * a simple task to show Executor's use of thread.
   * two advantage : reduce per-task invocation overhead,bound and manage resource.
   */
  private static String getResultFromExecutors(String question, List<String> engines) {

    ExecutorCompletionService<String> executor = new ExecutorCompletionService<>(Executors.newFixedThreadPool(5));
    engines.forEach(r -> executor.submit(
        () -> responseFrom(r + question))
    );
    try {
      return executor.take().get(); // once call of take ,once result.
    } catch (InterruptedException | ExecutionException e) {
      return null;
    }
  }

  /**
   * a simple task to show Parallel's use of thread
   * defult use ForkJoinPool.commonPool() to arrive.
   */
  private static String getResultFromParallel(String question, List<String> engines) {
    return engines.stream().parallel()
        .map(r -> responseFrom(r + question))
        .findAny()
        .get();
  }

  private static String responseFrom(String url) {
    try {
      return new OkHttpClient().newCall(
          new Request.Builder().url(url).build()).execute().body().string();
    } catch (IOException e) {
      return null;
    }
  }

  @AllArgsConstructor
  static class Message {
    String url;
  }

  @AllArgsConstructor
  static class Result {
    String html;
  }
  static class UrlFetcher extends UntypedActor

}

