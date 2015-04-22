# Oozie Job Submitter
This module helps to submit oozie jobs to any specified oozie cluster. The program will submit the job and wait till the job completes. 
At the end of the job, it will print the job info giving info on the status of the job.

## Steps to run
* Place the workflow application in hdfs

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
java -jar oozie-job-submitter-1.0-SNAPSHOT.jar https://ip-dev15.xenre.vendavo.com/oozie /Users/rthirumurthy/vendavo/saas20/oozie/configuration.xml
```

## Sample configuration.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
  <entry key="job">job</entry>
  <entry key="user.name">rohit</entry>
<properties
```



