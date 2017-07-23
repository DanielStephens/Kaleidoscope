package com.djs.kaleidoscope.conflict;


public class ConflictHunk {

    private final int start;

    private final int end;

    private final String ourCommitId;

    private final String ourCommit;

    private final String theirCommitId;

    private final String theirCommit;

    protected ConflictHunk(final int start, final int end, final String ourCommitId,
            final String ourCommit, final String theirCommitId, final String theirCommit) {
        this.start = start;
        this.end = end;
        this.ourCommitId = ourCommitId;
        this.ourCommit = ourCommit;
        this.theirCommitId = theirCommitId;
        this.theirCommit = theirCommit;
    }


}

