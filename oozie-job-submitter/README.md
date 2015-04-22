# Oozie Job Submitter
This module helps to submit oozie jobs to any specified oozie cluster. It also has support to listen to callbacks from oozie and logs the status of the submitted oozie jobs.

## Steps to run
* Build the project with the following command

```
mvn clean install
```

* Go to the target folder of oozie job submitted module

```
cd oozie-job-submitter/target
```

* Run the jar file

```
java -jar oozie-job-submitter-1.0-SNAPSHOT.jar
```

## Submitting a oozie job

Currently, submitting a oozie job is supported through Rest APIs.

* Place the workflow application in hdfs.
* (Optional) For callback support, make sure you have placed the oozie callback property. For example:

```
<property>
    <name>oozie.wf.workflow.notification.url</name>
    <value>http://10.40.76.131:8080/oozie/callback?jobId=$jobId&amp;status=$status</value>
  </property>
```

* Invoke the REST API `/oozie/submit` with request method POST. More details regarding this can be found in REST API section.
* (Optional) If you want callbacks, you can use `/oozie/callback`. Currently this service only supports logging of callbacks.

## REST APIs

### POST /oozie/submit

#### Request Body

```
{
  "oozieUrl":"http://localhost:11000/oozie/v2/",
  "xmlFileLocation":"/Users/rthirumurthy/vendavo/saas20/oozie/configuration.xml"
}
```

#### Parameters
* oozieUrl - The http/https url to your oozie cluster.
* xmlFileLocation - The location of your configuration.xml which you want to invoke the workflow with.

### GET /oozie/callback?status=$status&jobId=$jobId

#### Parameters
* status(String) - The status of the oozie workflow. $status will be replaced with actual status by oozie internally while making the callback.
* jobId(String) - The unique id identifying the oozie. $jobId will be replaced with actual job id by oozie internally while making the callback.


