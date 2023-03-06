# oop-design-patterns
## TASK

Create program to parse files from internet and from local filesystem. Initial file formats HTLM for web, JSON,XML for local filesystem.

## IMPLEMENTATION

FileParserFactoryProviderService creates **abstract factory** parser for **WEB** or for **FILESYSTEM**.

StaticFileParserFactory creates Parser for JSON and XML file formats.

WebFileParserFactory creates Parser for HTML file format.

Both StaticFileParserFactory and WebFileParserFactory implement FileParserFactory interface
and provide **factory method** to create particular file parser

## UML structure

![Abstract factory](/static/AbstractFactoryUML.png)


