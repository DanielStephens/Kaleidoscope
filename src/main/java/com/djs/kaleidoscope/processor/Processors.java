package com.djs.kaleidoscope.processor;

import java.io.IOException;
import java.util.Collection;

import com.djs.kaleidoscope.conflict.parser.TagConflictParser;
import com.djs.kaleidoscope.merger.GitMerger;
import com.djs.kaleidoscope.process.PomProcess;
import com.djs.kaleidoscope.process.Process;
import com.djs.kaleidoscope.request.Configuration;
import com.djs.kaleidoscope.request.ConflictRequest;
import com.google.common.collect.ImmutableList;

public class Processors {

    private static final Collection<Process> processes = ImmutableList.<Process> of(new PomProcess());

    public static ConflictProcessor defaultProcessor(final Configuration configuration, final ConflictRequest request)
            throws IOException {
        return new FirstApplicableConflictProcessor(new TagConflictParser(new GitMerger(), request), processes);
    }

}

