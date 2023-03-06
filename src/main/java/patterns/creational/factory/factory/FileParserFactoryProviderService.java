package patterns.creational.factory.factory;

import org.springframework.stereotype.Service;
import patterns.creational.factory.constant.FileSource;
import patterns.creational.factory.parser.Parser;

import java.util.List;

@Service
public class FileParserFactoryProviderService {

    public FileParserFactory<Parser> getFactory(FileSource fileSource) {
        return switch (fileSource) {
            case WEB -> new WebFileParserFactory();
            case FILESYSTEM -> new StaticFileParserFactory();
        };

    }
}
