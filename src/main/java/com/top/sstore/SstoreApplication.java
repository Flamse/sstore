package com.top.sstore;

import com.top.sstore.Study.TestAOP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

/**     扫描器的使用步骤
 *      1、写一个拦截器，实现HandlerIntercepter接口
 *      2、具体参考https://www.bilibili.com/video/av43630655/?p=17
 *
 *
 *      异常处理
 *      去掉springboot默认的异常处理逻辑
 *      @SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
 *
 *      使用ErrorPageRegistrar方法
 *      写一个类，实现ErrorPageRegistrar接口，然后实现ErrorPageRegistrar方法，在该方法里添加具体的错误处理逻辑
 *      （类似web.xml错误处理方式）
 *
 *      全局异常处理（参考GlobalExceptionHandler.class）
 *      1、写一个类，需要加上@ControllerAdvice注解
 *      2、写一个异常处理方法，方法上需要加上@ExceptionHandler(value = Exception.class)注解
 *
 */
//@EnableTransactionManagement    //开启事务支持，加了@Transactional，@EnableTransactionManagement没必要了
@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)   // 排除默认的异常处理逻辑
@MapperScan("com.top.sstore.dao")
public class SstoreApplication {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(SstoreApplication.class, args);
      /*  DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getCatalog());*/

//        context.getBean(TestAOP.class).add("root", "admin");
//        context.close();
    }
}
