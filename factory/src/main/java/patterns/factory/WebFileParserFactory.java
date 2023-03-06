package patterns.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import patterns.constant.FileType;
import patterns.parser.HTMLParser;
import patterns.parser.Parser;

@Slf4j
@Component
public class WebFileParserFactory implements FileParserFactory<Parser> {

    @Override
    public Parser getParser(FileType fileType) {
        return switch (fileType) {
            case HTML -> new HTMLParser();
            default -> throw new RuntimeException("Not found implementation");
        };
    }
}
