package Utilities;

import org.w3c.dom.Document;

public interface XMLParser {
    void loadSchema(String filename);

    Document readXMLFile(String filename);
}