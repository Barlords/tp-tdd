package fr.esgi.cleancode.model;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
public class SocialSecurityNumber {

    String number;

    @Builder
    public SocialSecurityNumber(String number)
    {
        if (!isValidSocialSecurityNumber(number))
        {
            throw new InvalidDriverSocialSecurityNumberException("Social Security Number is invalid");
        }
        this.number = number;
    }

    private boolean isValidSocialSecurityNumber(String socialSecurityNumber)
    {
        return null != socialSecurityNumber &&
                15 == socialSecurityNumber.length() &&
                StringUtils.isNumeric(socialSecurityNumber);
    }
}
