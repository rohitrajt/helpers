package org.rohit.pig.udfs;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.schema.Schema;

import java.io.IOException;

public class UPPER extends EvalFunc<String> {

    @Override
    public String exec(Tuple input) throws IOException {
        if(input == null || input.size() == 0) {
            return null;
        }

        try {
            String str = (String)input.get(0);
            return str.toUpperCase();
        } catch (Exception e) {
            throw new IOException("Caught exception processing input row ", e);
        }
    }

    @Override
    public Schema outputSchema(Schema input) {
        return input;
    }
}
