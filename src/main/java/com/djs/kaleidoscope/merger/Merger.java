package com.djs.kaleidoscope.merger;

import java.io.IOException;

public interface Merger {

    String merge(final String originalFile, final String currentFile, final String branchFile) throws IOException;
}

