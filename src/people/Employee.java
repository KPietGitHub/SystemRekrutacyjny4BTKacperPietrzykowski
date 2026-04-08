package people;

import application.Application;
import application.ApplicationStatus;
import school.School;
import utilities.DataValidator;

public class Employee extends Person {

    private String position;

    public Employee(String firstName, String lastName, String position) {

        super(firstName, lastName);

        if (!DataValidator.isNotEmpty(position)) {
            throw new IllegalArgumentException("Position cannot be empty");
        }

        this.position = position;
    }

    public void reviewApplication(Application application, boolean isAccepted) {

        if (application == null) {
            throw new IllegalArgumentException("Application cannot be null");
        }

        try {

            application.updateStatus(
                    isAccepted ? ApplicationStatus.ACCEPTED : ApplicationStatus.REJECTED
            );

            if (isAccepted) {
                School.incrementAcceptedStudentsCount();
            }

        } catch (Exception e) {

            System.out.println("Error reviewing application: " + e.getMessage());

        }
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String getDetails() {
        return "Employee: " + getFullName() + ", Position: " + position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {

        if (!DataValidator.isNotEmpty(position)) {
            throw new IllegalArgumentException("Position cannot be empty");
        }

        this.position = position;
    }
}