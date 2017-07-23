package com.djs.kaleidoscope.response.hunk;

import org.hamcrest.Description;

public interface HunkResponse {

    int collect(Description description, int exitCode);

}

