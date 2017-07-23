package com.djs.kaleidoscope.response;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.djs.kaleidoscope.response.hunk.HunkResponse;

public class CombinationResponse implements ChainResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(CombinationResponse.class);

    private final Collection<HunkResponse> responses;

    public CombinationResponse() {
        this.responses = new ArrayList<>();
    }

    private CombinationResponse(final Collection<HunkResponse> responses) {
        this.responses = responses;
    }

    @Override
    public void respond() {
        int exitCode = 1;
        Description description = new StringDescription();

        for (HunkResponse response : responses) {
            exitCode = response.collect(description, exitCode);
        }

        LOGGER.info(description.toString());
        System.exit(exitCode);
    }

    @Override
    public ChainResponse append(final HunkResponse response) {
        Collection<HunkResponse> snapshot = new ArrayList<>(responses);
        snapshot.add(response);
        return new CombinationResponse(snapshot);
    }



}

