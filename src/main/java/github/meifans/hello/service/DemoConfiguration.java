package github.meifans.hello.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * if want to scan different package(not package of the class),only to wirte
 * {ComponentScan ("specifically package")} or {ComponentScan
 * (basePackages="specifically")} ,there are same. and if want specify multiple
 * base package , wirte{ComponentScan(basePackages={"package name",
 * "package nema two"})} or
 * wirte{ComponentScan(basePackages={"classname.class","classname.class"})},then
 * scan those class belong to those package .
 * 
 * @author Administrator
 *
 */
@ComponentScan // 扫描这个类所在的包和下级包内的component
@Configuration
public class DemoConfiguration {

}
