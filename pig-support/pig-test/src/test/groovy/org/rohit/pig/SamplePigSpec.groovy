package org.rohit.pig

import org.apache.pig.pigunit.PigTest
import spock.lang.Specification


class SamplePigSpec extends Specification {

    void setup() {

    }

    void cleanup() {

    }

    def "execute" () {
        given:
            String[] args = ["n=2"]

            String[] input = ["yahoo", "yahoo", "yahoo", "twitter", "facebook", "facebook", "linkedin"]

            String[] output = ["(yahoo,3)", "(facebook,2)"]

        when:
            PigTest test = new PigTest("src/test/resources/test.pig", args)

        then:
            test.assertOutput("data", input, "queries_limit", output)
    }

    def "upper" () {
        given:
            String[] args = []
        when:
            PigTest test = new PigTest("src/test/resources/UPPER/upper.pig", args)
        then:
            test.assertOutput("data_upper",new File("src/test/resources/UPPER/upper_names.txt"))
    }
}
