package com.djs.kaleidoscope.response;

import com.djs.kaleidoscope.response.hunk.HunkResponse;

public interface ChainResponse extends ConflictResponse {

    ChainResponse append(HunkResponse response);

}

