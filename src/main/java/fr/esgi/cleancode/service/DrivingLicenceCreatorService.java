package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import fr.esgi.cleancode.model.SocialSecurityNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrivingLicenceCreatorService {

    private final InMemoryDatabase database;

    public DrivingLicence create(String socialSecurityNumber) {
        var validatedSocialSecurityNumber = SocialSecurityNumber.builder().number(socialSecurityNumber).build();
        var drivingLicence = DrivingLicence.builder().driverSocialSecurityNumber(validatedSocialSecurityNumber).build();
        return database.save(drivingLicence.getId(), drivingLicence);
    }
}
