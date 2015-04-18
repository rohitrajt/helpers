package org.rohit.oozie.jobSubmitter.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.validator.constraints.NotBlank

@JsonIgnoreProperties(ignoreUnknown = true)
class OozieSubmitJobRequest {

    @NotBlank
    String oozieUrl

    @NotBlank
    String xmlFileLocation
}
