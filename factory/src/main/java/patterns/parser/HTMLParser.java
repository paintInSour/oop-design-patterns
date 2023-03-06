package patterns.parser;

import org.springframework.stereotype.Component;
import patterns.file.File;
import patterns.file.HtmlFile;

@Component
public class HTMLParser implements Parser {
    @Override
    public File parse(String path) {
        return new HtmlFile();
    }
}
