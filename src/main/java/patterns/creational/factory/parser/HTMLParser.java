package patterns.creational.factory.parser;

import org.springframework.stereotype.Component;
import patterns.creational.factory.file.File;
import patterns.creational.factory.file.HtmlFile;

@Component
public class HTMLParser implements Parser {
    @Override
    public File parse(String path) {
        return new HtmlFile();
    }
}
