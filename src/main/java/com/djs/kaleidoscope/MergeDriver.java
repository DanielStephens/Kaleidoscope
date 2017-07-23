package com.djs.kaleidoscope;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.djs.kaleidoscope.processor.ConflictProcessor;
import com.djs.kaleidoscope.processor.Processors;
import com.djs.kaleidoscope.request.Configuration;
import com.djs.kaleidoscope.request.ConflictRequest;
import com.djs.kaleidoscope.response.ConflictResponse;

public class MergeDriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeDriver.class);

    public static void main(final String[] args) throws IOException {
        ConflictRequest request = new ConflictRequest(args[0], args[1], args[2], args[3]);
        Configuration configuration = new Configuration();


        ConflictProcessor processor = Processors.defaultProcessor(configuration, request);
        ConflictResponse response = processor.process(request);
        
        response.respond();
    }


}

