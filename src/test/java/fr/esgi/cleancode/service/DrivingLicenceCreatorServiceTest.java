package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DrivingLicenceCreatorServiceTest {

    private final InMemoryDatabase db = InMemoryDatabase.getInstance();
    private final DrivingLicenceCreatorService creatorService = new DrivingLicenceCreatorService(db);

    @Test
    void should_create_and_save_driving_licence_in_database()
    {
        var given = creatorService.create("123456789123456");
        var actual = db.findById(given.getId());
        assertThat(actual).containsSame(given);
    }

}
