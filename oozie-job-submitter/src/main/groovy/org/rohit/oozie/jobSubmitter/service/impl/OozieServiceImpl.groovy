package org.rohit.oozie.jobSubmitter.service.impl

import groovy.util.logging.Slf4j
import org.rohit.oozie.jobSubmitter.models.OozieSubmitJobRequest
import org.rohit.oozie.jobSubmitter.models.OozieSubmitResponse
import org.rohit.oozie.jobSubmitter.service.OozieService
import org.rohit.oozie.jobSubmitter.utils.OozieConnector
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component('oozieService')
@Slf4j
class OozieServiceImpl implements OozieService {

    @Autowired
    OozieConnector oozieConnector

    @Override
    OozieSubmitResponse submitOozieJob(OozieSubmitJobRequest oozieSubmitJobRequest) {
        log.info("Submitting Oozie Job")

        String jobId = oozieConnector.createJob(oozieSubmitJobRequest.oozieUrl, new File(oozieSubmitJobRequest.xmlFileLocation).text)

        oozieConnector.startJob(oozieSubmitJobRequest.oozieUrl, jobId)

        return new OozieSubmitResponse(jobId:jobId)
    }

    @Override
    void handleCallback(String jobId, String status) {
        log.info("\"method\"=\"handleCallBack\" \"message\"=\"Oozie job with id ${jobId} status : ${status}\"")
    }
}
