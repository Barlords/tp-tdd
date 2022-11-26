package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceRemoverPointService {

    private final InMemoryDatabase database;

    public DrivingLicence removePoint(UUID drivingLicenceId, int nbPointToRemove) {
        var optionalDrivingLicence = database.findById(drivingLicenceId);
        if (optionalDrivingLicence.isEmpty())
        {
            throw new ResourceNotFoundException("Driving Licence not found");
        }
        else {
            var drivingLicence = optionalDrivingLicence.get();
            drivingLicence = drivingLicence.removePoint(nbPointToRemove);
            return database.save(drivingLicence.getId(), drivingLicence);
        }
    }
}
