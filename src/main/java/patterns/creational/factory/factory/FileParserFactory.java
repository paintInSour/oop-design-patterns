package patterns.creational.factory.factory;

import patterns.creational.factory.constant.FileSource;
import patterns.creational.factory.constant.FileType;

public interface FileParserFactory<T> {
    T getParser(FileType fileType);

}
