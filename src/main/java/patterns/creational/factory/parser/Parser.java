package patterns.creational.factory.parser;

import patterns.creational.factory.file.File;

public interface Parser {

    File parse(String path);
}
