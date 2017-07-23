package com.djs.kaleidoscope.conflict.parser;

import java.io.IOException;

import com.djs.kaleidoscope.conflict.Conflict;

public interface ConflictParser {

    boolean hasNext();

    Conflict next() throws IOException;

}

