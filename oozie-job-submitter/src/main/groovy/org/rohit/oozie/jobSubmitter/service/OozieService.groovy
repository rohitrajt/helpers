package org.rohit.oozie.jobSubmitter.service

import org.rohit.oozie.jobSubmitter.models.OozieSubmitJobRequest

interface OozieService {

    void submitOozieJob(OozieSubmitJobRequest oozieSubmitJobRequest)

    void handleCallback(String jobId, String status)
}