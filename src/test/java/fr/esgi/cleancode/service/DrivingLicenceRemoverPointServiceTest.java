package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DrivingLicenceRemoverPointServiceTest {

    @InjectMocks
    private DrivingLicenceRemoverPointService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_remove_point_of_driving_licence_and_save_it()
    {
        final var id = UUID.randomUUID();
        final var given = DrivingLicence.builder().id(id).build();
        database.save(id, given);
        var actual = service.removePoint(id, 2);

        assertThat(given.getAvailablePoints()-2).isEqualTo(actual.getAvailablePoints());
    }

}
