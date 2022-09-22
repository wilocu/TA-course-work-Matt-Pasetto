package Utilities;

import java.text.ParseException;

public interface XMLAdapter <X, Y>{
    X unmarshall(Y element) throws ParseException;

    Y marshall(X element);
}
