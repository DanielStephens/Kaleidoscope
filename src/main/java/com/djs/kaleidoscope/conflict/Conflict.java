package com.djs.kaleidoscope.conflict;

import com.djs.kaleidoscope.conflict.resolution.ResolutionState;
import com.djs.kaleidoscope.conflict.resolution.Unresolved;
import com.djs.kaleidoscope.request.ConflictRequest;

public class Conflict {

    private final ConflictRequest request;

    private final ConflictHunk hunk;

    private ResolutionState state;

    protected Conflict(final ConflictRequest request, final ConflictHunk hunk) {
        this.request = request;
        this.hunk = hunk;
        state = new Unresolved();
    }

}

