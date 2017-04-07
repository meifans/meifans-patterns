package github.meifans.patterns.singleton;

/**
 * 作为对象的创建模式，单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。这个类称为单例类。
 *
 * 特点：
 * 1.单例类只能有一个实例
 * 2.单例类必须自己创建自己的唯一实例
 * 3.单例类必须为其他对象提供这一实例
 */
public interface Singleton {


  /**
   * 单元素枚举实现单例
   * 由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
   */
  enum BestSingle {

    instance;

    String property;

    public void function() {

    }
  }

  /**
   * 类装载时就实例化
   */
  class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
      return instance;
    }
  }

  /**
   * 在第一次获取实例时才实例化，对静态工厂方法同步处理以处理多线程
   * 缺点：每次获取实例时都需要同步，时间慢。但相比于eager更节省空间
   */
  class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
      if (instance == null) {
        instance = new LazySingleton();
      }
      return instance;
    }
  }

  /**
   * 双重检查的方式，利用volatile消除了本地线程的缓存，直接操作共享内存，使多个线程能读到该变量的最新值。
   * 既是线程安全的，又比lazy性能快些。
   *
   * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高。
   */
  class DoubleSingleton {

    private static volatile DoubleSingleton instance = null;

    private DoubleSingleton() {

    }

    public static DoubleSingleton getInstance() {
      if (instance == null) {
        synchronized (DoubleSingleton.class) {
          if (instance == null) {
            instance = new DoubleSingleton();
          }
        }
      }
      return instance;
    }
  }

  /**
   * InternalSingleton为静态内部类，在调用getInstance()之前它不会被jvm加载，也就不会实例化instance
   * jvm来执行静态变量初始化，天然线程安全。
   * 延迟初始化并没有增加getInstance的访问成本
   */
  class SingletonHolder {

    private SingletonHolder() {

    }

    public static InternalSingleton getInstance() {
      return InternalSingleton.instance;
    }

    static class InternalSingleton {

      private static InternalSingleton instance = new InternalSingleton();
    }
  }


}
