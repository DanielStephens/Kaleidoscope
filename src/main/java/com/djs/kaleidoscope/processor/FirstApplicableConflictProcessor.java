package com.djs.kaleidoscope.processor;

import java.io.IOException;
import java.util.Collection;

import com.djs.kaleidoscope.conflict.Conflict;
import com.djs.kaleidoscope.conflict.parser.ConflictParser;
import com.djs.kaleidoscope.process.Process;
import com.djs.kaleidoscope.request.ConflictRequest;
import com.djs.kaleidoscope.response.ChainResponse;
import com.djs.kaleidoscope.response.ConflictResponse;
import com.djs.kaleidoscope.response.Responses;
import com.djs.kaleidoscope.response.hunk.HunkResponse;
import com.djs.kaleidoscope.response.hunk.HunkResponses;

public class FirstApplicableConflictProcessor implements ConflictProcessor {

    private final ConflictParser parser;

    private final Collection<Process> processes;

    protected FirstApplicableConflictProcessor(final ConflictParser parser, final Collection<Process> processes) {
        this.parser = parser;
        this.processes = processes;
    }

    @Override
    public ConflictResponse process(final ConflictRequest request) throws IOException {
        ChainResponse response = Responses.chain();

        
        while(parser.hasNext()){
            response.append(resolveConflict(parser.next()));
        }

        return response;
    }

    private HunkResponse resolveConflict(final Conflict conflict) {
        for (Process process : processes) {
            if (process.canHandle(conflict)) {
                return process.process(conflict);
            }
        }

        return HunkResponses.failure("No applicable process exists to handle this conflict");
    }


}

