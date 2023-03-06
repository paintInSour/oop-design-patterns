package patterns.parser;

import patterns.file.File;
import patterns.file.XMLFile;

public class XMLParser implements Parser {


    @Override
    public File parse(String path) {
        return new XMLFile();
    }
}
