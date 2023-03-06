package patterns.factory;

import patterns.constant.FileType;

public interface FileParserFactory<T> {
    T getParser(FileType fileType);

}
