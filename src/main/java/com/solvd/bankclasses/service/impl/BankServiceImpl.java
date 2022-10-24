
package com.solvd.bankclasses.service.impl;


import com.solvd.bankclasses.daoclasses.IBankDAO;
import com.solvd.bankclasses.daoclasses.implemented.BankDAO;
import com.solvd.bankclasses.places.Bank;
import com.solvd.bankclasses.service.BankService;
import org.apache.log4j.Logger;
import com.solvd.bankclasses.utilities.XMLParserDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
    private static final Logger LOGGER = Logger.getLogger(BankServiceImpl.class.getName());

    private final IBankDAO bankDAOimpl = new BankDAO();;
    XMLParserDOM bankParser = new XMLParserDOM();

    public BankServiceImpl() {
    }

    public Bank getBankByID(int id) {
        try {
            return bankDAOimpl.getObjectByID(id);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Bank> parseFromXmlDOM(String schemaName, String xmlName) {
        bankParser.loadSchema(schemaName);
        Document doc = bankParser.readXMLFile(xmlName, Document.class);
        bankParser.validate(doc);

        NodeList list = doc.getElementsByTagName("bank");
        List<Bank> bank = new ArrayList<Bank>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                Bank b = new Bank();
                b.setId(Integer.parseInt(element.getAttribute("id")));
                bank.add(b);
                try {
                    bankDAOimpl.create(b);
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        return bank;
    }
}