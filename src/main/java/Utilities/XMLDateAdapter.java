package Utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLDateAdapter implements  XMLAdapter<Date, String>{

    @Override
    public Date unmarshall(String date) throws ParseException {
        return (Date) new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
    }

    @Override
    public String marshall(Date element) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(element);
    }
}
