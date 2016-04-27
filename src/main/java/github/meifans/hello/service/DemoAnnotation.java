package github.meifans.hello.service;

import org.springframework.stereotype.Service;

@Service("godie") // 可以自主命名，在context中bean的id会来自名字的第一个小写字母，因此可以改变id
public class DemoAnnotation {

}
