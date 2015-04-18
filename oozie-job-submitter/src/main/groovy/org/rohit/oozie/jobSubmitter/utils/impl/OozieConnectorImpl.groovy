package org.rohit.oozie.jobSubmitter.utils.impl

import groovy.util.logging.Slf4j
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import groovyx.net.http.RESTClient
import org.rohit.oozie.jobSubmitter.utils.OozieConnector
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component('oozieConnector')
@Slf4j
class OozieConnectorImpl implements OozieConnector {

    @Override
    String createJob(String oozieUrl, String workflowConfigXml) {
        log.info("Method=\"createJob\",workflowConfigXml=\"${workflowConfigXml}\"")
        String oozieJobCreateUrl = oozieUrl + "jobs"
        RESTClient oozieClient = new RESTClient(oozieJobCreateUrl)
        def response = oozieClient.post(
                body: workflowConfigXml,
                requestContentType: 'application/xml;charset=UTF-8'
        )

        if (response.status == HttpStatus.CREATED.value()) {
            return response?.responseData?.id
        } else {
            log.error("Oozie job create failed with response ${response.status} for object with id: " + id)
            def headers = response.getResponseHeaders()
            throw new Exception("Oozie job create failed with response ${response.status}, oozie-error-code=${headers.get("oozie-error-code")}, " +
                    "oozie-error-message=${headers.get("oozie-error-message")} ")
        }
    }

    @Override
    boolean startJob(String oozieUrl, String jobId) {
        log.info("Method=\"startJob\", jobId=\"${jobId}\"")
        String oozieJobStartUrl = oozieUrl + "job/"
        HTTPBuilder oozieClient = new HTTPBuilder(oozieJobStartUrl + jobId + '?action=start')

        oozieClient.request(Method.PUT) { req ->

            response.success = { resp, json ->
                return true

            }

            response.failure = { resp, json ->
                log.error("Oozie job start failed with response ${response.status} for jobId: " + jobId)
                def headers = resp.getResponseHeaders()
                throw new Exception("Oozie job start failed with response ${resp.status}, oozie-error-code=${headers.get("oozie-error-code")}, " +
                        "oozie-error-message=${headers.get("oozie-error-message")} ")

            }
        }
    }

    @Override
    boolean stopJob(String oozieUrl, String jobId) {
        return false
    }
}
