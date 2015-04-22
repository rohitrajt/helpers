package org.rohit.oozie.jobSubmitter.utils


interface OozieConnector {

    void submitJob(String oozieUrl, String worflowConfigXml)

}