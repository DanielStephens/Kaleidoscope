package com.djs.kaleidoscope.conflict.parser;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.djs.kaleidoscope.conflict.Conflict;
import com.djs.kaleidoscope.conflict.ConflictBuilder;
import com.djs.kaleidoscope.merger.Merger;
import com.djs.kaleidoscope.request.ConflictRequest;

public class TagConflictParser implements ConflictParser {

    private static final String CONFLICT_START_MARKER = "<<<<<<< ";

    private static final String CONFLICT_SEPARATOR = "=======";

    private static final String CONFLICT_END_MARKER = ">>>>>>> ";

    private static final String commitHash = "[a-zA-Z0-9]{40}";

    private static final String anything = "(?s).*?";

    private static final String lineEnd = "\r?\n";

    private final ConflictBuilder conflictBuilder;

    private final Matcher matcher;

    private Conflict current;

    public TagConflictParser(final Merger merger, final ConflictRequest request) throws IOException {
        conflictBuilder = new ConflictBuilder(request);

        Pattern pattern = Pattern.compile(conflictRegex());
        matcher = pattern.matcher(request.merge(merger));
    }

    @Override
    public boolean hasNext() {
        if (current != null) {
            return true;
        }

        if (matcher.find()) {
            current = conflictBuilder.from(matcher.start(), matcher.end(), matcher.group(1), matcher.group(2),
                    matcher.group(3), matcher.group(4));
            return true;
        }

        return false;
    }

    @Override
    public Conflict next() throws IOException {
        if (hasNext()) {
            Conflict temp = current;
            current = null;
            return temp;
        }

        throw new IOException("Nothing left to read!");
    }

  //@formatter:off
    private String conflictRegex(){
        StringBuilder sb = new StringBuilder(256)
                
            .append(CONFLICT_START_MARKER).append(regexGroupOf(commitHash, lineEnd))
            
            .append(regexGroupOf(anything)) //--OURS (in gits opinion)
            
            .append(CONFLICT_SEPARATOR).append(lineEnd)
            
            .append(regexGroupOf(anything)) //--THEIRS (in gits opinion)
            
            .append(CONFLICT_END_MARKER).append(regexGroupOf(anything, lineEnd));
        
        return sb.toString();
    }
    //@formatter:on

    private String regexGroupOf(final String... regexes) {
        StringBuilder sb = new StringBuilder(128);

        sb.append('(');

        for (String regex : regexes) {
            sb.append(regex);
        }

        sb.append(')');
        return sb.toString();
    }

}

