package com.solvd.bankclasses.service.impl;

import com.solvd.bankclasses.accounts.Account;
import com.solvd.bankclasses.accounts.Accounts;
import com.solvd.bankclasses.daoclasses.IAccountsDAO;
import com.solvd.bankclasses.daoclasses.implemented.AccountsDAO;
import com.solvd.bankclasses.service.AccountService;
import org.apache.log4j.Logger;
import com.solvd.bankclasses.utilities.XMLParserDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountServiceImpl  implements AccountService {
    private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class.getName());

    private final IAccountsDAO accountsDAOimpl = new AccountsDAO();
    XMLParserDOM domParser;

    public void createAccount(Accounts a){
        try {
            a.setId(accountsDAOimpl.create(a));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public List<Accounts> getAccountByUser(int userID) {
        try {
            return accountsDAOimpl.getAccountsByUser(userID);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public AccountServiceImpl() {
        domParser = new XMLParserDOM();
    }

    @Override
    public List<Accounts> parseFromXmlDOM(String schemaName, String xmlName) {
        domParser.loadSchema(schemaName);
        Document doc = domParser.readXMLFile(xmlName, Document.class);
        domParser.validate(doc);
        NodeList list = doc.getElementsByTagName("discount");
        List<Accounts> accounts = new ArrayList<Accounts>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                Accounts a = new Accounts();
                a.setId(Integer.parseInt(element.getAttribute("id")));
                a.setBalance(Double.parseDouble(element.getAttribute("balance")));
                a.setPersonId(Integer.parseInt(element.getAttribute("person_id")));
                accounts.add(a);
                try {
                    accountsDAOimpl.create(a);
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        return accounts;
    }

    @Override
    public void parseFromXmlJAXB(String schemaName, String xmlName) {
        Accounts xmlAccounts = new Accounts();
        try {
            JAXBContext context = JAXBContext.newInstance(Accounts.class);
            xmlAccounts = (Accounts) context.createUnmarshaller().unmarshal(new FileReader(xmlName));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.warn(e.getMessage());
        }

        try {
            accountsDAOimpl.create(xmlAccounts);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }

    }
}
