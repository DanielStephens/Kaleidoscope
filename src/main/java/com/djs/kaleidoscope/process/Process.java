package com.djs.kaleidoscope.process;

import com.djs.kaleidoscope.conflict.Conflict;
import com.djs.kaleidoscope.response.hunk.HunkResponse;

public interface Process {

    boolean canHandle(Conflict conflict);

    HunkResponse process(Conflict conflict);

}

