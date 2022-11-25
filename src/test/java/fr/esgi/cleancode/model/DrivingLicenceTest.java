package fr.esgi.cleancode.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrivingLicenceTest {

    @Test
    void should_be_valid_driver_licence()
    {
        final var socialSecurityNumber = SocialSecurityNumber.builder().number("123456789123456").build();
        Assertions.assertThatNoException().isThrownBy(() -> DrivingLicence.builder().driverSocialSecurityNumber(socialSecurityNumber).build());
    }

}
