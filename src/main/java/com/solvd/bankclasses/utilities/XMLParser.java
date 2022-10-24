package com.solvd.bankclasses.utilities;

import javax.xml.validation.Schema;
import java.util.List;

public interface XMLParser<T> {
    public Schema loadSchema(String filename);

    public T readXMLFile(String filename, Class<T> clazz);

    public List<T> unmarshal(String filename, Class<T> clazz);
}