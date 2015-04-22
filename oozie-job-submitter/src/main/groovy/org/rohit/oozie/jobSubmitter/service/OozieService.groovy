package org.rohit.oozie.jobSubmitter.service

import org.rohit.oozie.jobSubmitter.models.OozieSubmitJobRequest
import org.rohit.oozie.jobSubmitter.models.OozieSubmitResponse

interface OozieService {

    OozieSubmitResponse submitOozieJob(OozieSubmitJobRequest oozieSubmitJobRequest)

    void handleCallback(String jobId, String status)
}