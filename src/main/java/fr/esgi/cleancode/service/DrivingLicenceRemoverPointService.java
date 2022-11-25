package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicenceRemoverPointService {

    private final InMemoryDatabase database;

    public DrivingLicence removePoint(UUID drivingLicenceId, int nbPointToRemove) {
        return DrivingLicence.builder().build();
    }
}
