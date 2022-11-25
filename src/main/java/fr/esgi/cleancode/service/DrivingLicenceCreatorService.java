package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingLicenceCreatorService {

    private final InMemoryDatabase database;

    public DrivingLicence create(String socialSecurityNumber) {
        return DrivingLicence.builder().build();
    }
}
