package org.rohit.oozie.jobSubmitter

import groovy.util.logging.Slf4j
import org.rohit.oozie.jobSubmitter.models.OozieSubmitJobRequest
import org.rohit.oozie.jobSubmitter.service.OozieService
import org.rohit.oozie.jobSubmitter.service.impl.OozieServiceImpl
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.ImportResource
import org.springframework.context.support.ClassPathXmlApplicationContext

@Slf4j
@ImportResource(value = 'classpath:oozie-job-submitter-context.xml')
class App {

    public static void main(String[] args) {

        if(!args.length == 2) {
            throw new Exception("Required number of arguments not present")
        }

        log.info("Running Oozie Job Submitter")

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("oozie-job-submitter-context.xml")

        OozieService oozieService = (OozieService) applicationContext.getBean(OozieServiceImpl.class)

        OozieSubmitJobRequest oozieSubmitJobRequest = new OozieSubmitJobRequest(
            oozieUrl: args[0],
            xmlFileLocation: args[1]
        )

        oozieService.submitOozieJob(oozieSubmitJobRequest)

    }
}
