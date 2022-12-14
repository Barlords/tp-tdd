package fr.esgi.cleancode.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Value
@Builder
public class DrivingLicence {
    UUID id;
    SocialSecurityNumber driverSocialSecurityNumber;

    @With
    @Default
    int availablePoints = 12;

    public DrivingLicence removePoint(int nbPointToRemove)
    {
        var newPoint = Math.max(availablePoints - nbPointToRemove, 0);
        return this.withAvailablePoints(newPoint);
    }
}
