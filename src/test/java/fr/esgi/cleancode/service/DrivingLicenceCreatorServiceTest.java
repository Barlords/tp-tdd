package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.assertj.core.api.Assertions.assertThat;

public class DrivingLicenceCreatorServiceTest {

    @InjectMocks
    private DrivingLicenceCreatorService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_create_and_save_driving_licence_in_database()
    {
        var given = service.create("123456789123456");
        var actual = database.findById(given.getId());
        assertThat(actual).containsSame(given);
    }

    @Test
    void should_not_create()
    {
        Assertions.assertThatException().isThrownBy(() -> service.create("123456"));
    }

}
