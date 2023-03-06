package patterns.parser;

import patterns.file.File;

public interface Parser {

    File parse(String path);
}
