package com.djs.kaleidoscope.conflict;

import com.djs.kaleidoscope.request.ConflictRequest;

public class ConflictBuilder {

    private final ConflictRequest request;

    public ConflictBuilder(final ConflictRequest request) {
        this.request = request;
    }

    public Conflict from(final int start, final int end, final String ourCommitId, final String ourCommit,
            final String theirCommitId, final String theirCommit) {
        return new Conflict(request, hunkFrom(start, end, ourCommitId, ourCommit, theirCommitId, theirCommit));
    }

    private ConflictHunk hunkFrom(final int start, final int end, final String ourCommitId, final String ourCommit,
            final String theirCommitId,
            final String theirCommit) {
        return new ConflictHunk(start, end, ourCommitId, ourCommit, theirCommitId, theirCommit);
    }

}

