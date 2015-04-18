package org.rohit.oozie.jobSubmitter.utils


interface OozieConnector {

    String createJob(String oozieUrl, String worflowConfigXml)

    boolean startJob(String oozieUrl, String jobId)

    boolean stopJob(String oozieUrl, String jobId)

}