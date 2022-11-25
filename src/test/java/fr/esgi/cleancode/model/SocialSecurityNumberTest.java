package fr.esgi.cleancode.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class SocialSecurityNumberTest {

    @Test
    void should_throw_InvalidDriverSocialSecurityNumberException()
    {
        Assertions.assertThatException().isThrownBy(() -> SocialSecurityNumber.builder().number(null).build());
        Assertions.assertThatException().isThrownBy(() -> SocialSecurityNumber.builder().number("1891").build());
        Assertions.assertThatException().isThrownBy(() -> SocialSecurityNumber.builder().number("A23456789874563").build());
    }

    @Test
    void should_be_valid_social_security_number()
    {
        Assertions.assertThatNoException().isThrownBy(() -> SocialSecurityNumber.builder().number("123456789123456").build());
    }
}
