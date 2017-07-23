package com.djs.kaleidoscope.process;

import java.util.regex.Pattern;

import com.djs.kaleidoscope.conflict.Conflict;
import com.djs.kaleidoscope.response.hunk.HunkResponse;

public class PomProcess implements Process {

    private static final String EXPECTED_FILE_NAME = "pom.xml";

    private static final String USE_EXISTING_FLAG = "--use-existing";

    private static final Pattern VERSION_NUMBER_PATTERN = Pattern.compile("\\s*<([^>]+)>\\d+\\.\\d+[^<]*</([^>]+)>");

    @Override
    public boolean canHandle(final Conflict conflict) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public HunkResponse process(final Conflict conflict) {
        // TODO Auto-generated method stub
        return null;
    }
}

