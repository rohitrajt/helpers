package org.rohit.oozie.jobSubmitter

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ImportResource
import org.springframework.context.support.ClassPathXmlApplicationContext

@Slf4j
@SpringBootApplication
@ImportResource(value = 'classpath:oozie-job-submitter-context.xml')
class App {

    public static void main(String[] args) {
        log.info("Running Oozie Job Submitter")
        SpringApplication.run(App, args)
    }
}
