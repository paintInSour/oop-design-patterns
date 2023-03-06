package patterns.service;

import org.springframework.stereotype.Service;
import patterns.constant.FileSource;
import patterns.factory.FileParserFactory;
import patterns.factory.StaticFileParserFactory;
import patterns.factory.WebFileParserFactory;
import patterns.parser.Parser;

@Service
public class FileParserFactoryProviderService {

    public FileParserFactory<Parser> getFactory(FileSource fileSource) {
        return switch (fileSource) {
            case WEB -> new WebFileParserFactory();
            case FILESYSTEM -> new StaticFileParserFactory();
        };

    }
}
