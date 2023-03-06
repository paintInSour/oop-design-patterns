package patterns.parser;

import org.springframework.stereotype.Component;
import patterns.file.File;
import patterns.file.JsonFile;

@Component
public class JSONParser implements Parser {
    @Override
    public File parse(String path) {
        return new JsonFile();
    }
}
