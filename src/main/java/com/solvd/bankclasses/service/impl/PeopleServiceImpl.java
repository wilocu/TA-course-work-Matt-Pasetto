package com.solvd.bankclasses.service.impl;

import com.solvd.bankclasses.daoclasses.IPeopleDAO;
import com.solvd.bankclasses.daoclasses.implemented.PeopleDAO;
import com.solvd.bankclasses.people.People;
import com.solvd.bankclasses.service.PeopleService;
import com.solvd.bankclasses.utilities.XMLParserDOM;
import org.apache.log4j.Logger;
import org.w3c.dom.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeopleServiceImpl implements PeopleService {
    private static final Logger LOGGER = Logger.getLogger(PeopleServiceImpl.class.getName());
    private static final Scanner input = new Scanner(System.in);

    private final IPeopleDAO peopleDAOimpl = new PeopleDAO();;
    XMLParserDOM peopleParser = new XMLParserDOM();

    public PeopleServiceImpl() {
    }

    public People getPeopleByID(int id) {
        try {
            return peopleDAOimpl.getObjectByID(id);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public People addCustomer() {
        LOGGER.info("Please enter your first name: ");
        String nameF = input.nextLine();
        LOGGER.info("Please enter your last name: ");
        String nameL = input.nextLine();

        People p = new People(nameF, nameL);

        try {
            p.setId(peopleDAOimpl.create(p));
            LOGGER.info(p.firstName + " " + p.lastName + " you have been added to the system");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return p;
    }

    public People addCustomerForTest() {
        String nameF = "testF";
        String nameL = "testL";

        People p = new People(nameF, nameL);

        try {
            p.setId(peopleDAOimpl.create(p));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return p;
    }

    @Override
    public List<People> parseFromXmlDOM(String schemaName, String xmlName) {
        peopleParser.loadSchema(schemaName);
        Document doc = peopleParser.readXMLFile(xmlName, Document.class);
        peopleParser.validate(doc);

        NodeList list = doc.getElementsByTagName("insurance");
        List<People> people = new ArrayList<People>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                People p = new People();
                p.setId(Integer.parseInt(element.getAttribute("id")));
                p.setFirstName(element.getElementsByTagName("first_name").item(0).getTextContent());
                p.setLastName(element.getElementsByTagName("last_name").item(0).getTextContent());
                p.setPersonType(Integer.parseInt(element.getAttribute("person_type")));

                people.add(p);
                try {
                    peopleDAOimpl.create(p);
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        return people;
    }
}
