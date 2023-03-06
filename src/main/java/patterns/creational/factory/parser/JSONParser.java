package patterns.creational.factory.parser;

import org.springframework.stereotype.Component;
import patterns.creational.factory.file.File;
import patterns.creational.factory.file.JsonFile;

@Component
public class JSONParser implements Parser {
    @Override
    public File parse(String path) {
        return new JsonFile();
    }
}
