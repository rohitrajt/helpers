package org.rohit.oozie.jobSubmitter.controllers

import groovy.util.logging.Slf4j
import org.rohit.oozie.jobSubmitter.models.OozieSubmitJobRequest
import org.rohit.oozie.jobSubmitter.models.OozieSubmitResponse
import org.rohit.oozie.jobSubmitter.service.OozieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Slf4j
class OozieController {

    @Autowired
    OozieService oozieService

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    void getCallBack() {
        log.info("Oozie Controller - get Call back")

        oozieService.handleCallback()
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    OozieSubmitResponse submit(@RequestBody OozieSubmitJobRequest oozieSubmitJobRequest) {
        log.info("Oozie Controller - Submit Oozie Job")

        return oozieService.submitOozieJob(oozieSubmitJobRequest)
    }
}
