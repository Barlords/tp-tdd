package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DrivingLicenceFinderServiceTest {

    @InjectMocks
    private DrivingLicenceFinderService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_find() {
        final var id = UUID.randomUUID();
        final var given = DrivingLicence.builder().id(id).build();
        when(database.findById(id)).thenReturn(Optional.ofNullable(given));
        var actual = service.findById(id);

        assertThat(actual).containsSame(given);
    }

    @Test
    void should_not_find() {
        final var id = UUID.randomUUID();
        var actual = service.findById(id);
        assertThat(actual).isEqualTo(Optional.empty());
    }
}