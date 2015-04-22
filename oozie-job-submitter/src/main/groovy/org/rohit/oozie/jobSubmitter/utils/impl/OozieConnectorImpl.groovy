package org.rohit.oozie.jobSubmitter.utils.impl

import groovy.util.logging.Slf4j
import org.apache.oozie.client.OozieClient
import org.apache.oozie.client.WorkflowJob
import org.rohit.oozie.jobSubmitter.utils.OozieConnector
import org.springframework.stereotype.Component

@Component('oozieConnector')
@Slf4j
class OozieConnectorImpl implements OozieConnector {

    @Override
    void submitJob(String oozieUrl, String workflowConfigXml ) {
        log.info("Method=\"createJob\",workflowConfigXml=\"${workflowConfigXml}\"")
        Properties properties = new Properties()

        properties.loadFromXML(new ByteArrayInputStream(workflowConfigXml.getBytes("UTF-8")))

        // Get a OozieClient for local Oozie
        OozieClient oozieClient = new OozieClient(oozieUrl)

        //Submit and start the workflow job
        String jobId = oozieClient.run(properties)

        log.info("\"method\"=\"submitJob\", \"message\"=\"job with id ${jobId} submitted\"")

        WorkflowJob jobInfo = oozieClient.getJobInfo(jobId)

        while(jobInfo.getStatus() ==  WorkflowJob.Status.RUNNING) {
            log.info("WOrkflow job with id ${jobId} running")
            Thread.sleep(10 * 1000)
        }

        log.info("Worfklow job with id ${jobId} completed with status ${jobInfo.getStatus()}")

        log.info("${jobInfo}")
    }
}
