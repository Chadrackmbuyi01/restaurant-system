package za.ac.cput.repository.helper;


import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;

import java.util.UUID;


public class Helper {

    public static String generateID()
    {

        return UUID.randomUUID().toString();
    }

    public static boolean isEmptyOrNull(String str)
    {
        return StringUtils.isEmpty(str);
    }
    public static String EmptyIfNull(String str)
    {
        if(isEmptyOrNull(str))
            return "";
        return str;
    }

    public static void checkStringPara(String paraName, String paraValue) {
        if (isEmptyOrNull(paraValue))
            throw new IllegalArgumentException("Invalid Value for:" + paraName);

    }
    public static void IsValidEmail(String str) {
        if (!EmailValidator.getInstance().isValid(str))
            throw new IllegalArgumentException("Invalid Email" );

    }
}
