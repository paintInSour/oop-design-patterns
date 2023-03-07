# Abstract factory/Factory method
## ABSTRACT TASK

Create program to parse files from internet and from local filesystem. Initial file formats HTLM for web, JSON,XML for local filesystem.

## IMPLEMENTATION

FileParserFactoryProviderService creates **abstract factory** parser for **WEB** or for **FILESYSTEM**.

StaticFileParserFactory creates Parser for JSON and XML file formats.

WebFileParserFactory creates Parser for HTML file format.

Both StaticFileParserFactory and WebFileParserFactory implement FileParserFactory interface
and provide **factory method** to create particular file parser

### [Workflow demonstrated here](https://github.com/paintInSour/oop-design-patterns/blob/master/factory/src/test/java/patterns/FactoryApplicationTests.java) 

## Abstract factory usage diagram

![Abstract factory](https://github.com/paintInSour/oop-design-patterns/blob/master/factory/static/AbstractFactoryDiagram.png?raw=true)


