package com.djs.kaleidoscope.processor;

import java.io.IOException;

import com.djs.kaleidoscope.request.ConflictRequest;
import com.djs.kaleidoscope.response.ConflictResponse;

public interface ConflictProcessor {

    ConflictResponse process(ConflictRequest request) throws IOException;

}

