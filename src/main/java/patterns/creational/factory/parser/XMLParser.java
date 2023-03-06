package patterns.creational.factory.parser;

import patterns.creational.factory.file.File;
import patterns.creational.factory.file.XMLFile;

public class XMLParser implements Parser {


    @Override
    public File parse(String path) {
        return new XMLFile();
    }
}
