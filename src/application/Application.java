package application;

import people.Candidate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private Candidate candidate;
    private ApplicationStatus status;
    private List<String> statusHistory;

    public Application(Candidate candidate) {

        if (candidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null");
        }

        this.candidate = candidate;
        this.status = ApplicationStatus.SUBMITTED;
        this.statusHistory = new ArrayList<>();

        statusHistory.add("SUBMITTED");
    }

    public void updateStatus(ApplicationStatus newStatus) {

        if (newStatus == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        try {

            this.status = newStatus;
            statusHistory.add(newStatus.toString());

        } catch (Exception e) {

            System.out.println("Error updating status: " + e.getMessage());

        }
    }

    public void viewApplicationHistory() {

        if (statusHistory == null || statusHistory.isEmpty()) {
            throw new IllegalStateException("No status history available");
        }

        try {

            System.out.println("\nApplication history for: " + candidate.getFullName());

            for (String status : statusHistory) {
                System.out.println(" - " + status);
            }

        } catch (Exception e) {

            System.out.println("Error displaying application history: " + e.getMessage());

        }
    }

    public Candidate getCandidate() {

        if (candidate == null) {
            throw new IllegalStateException("Candidate not set");
        }

        return candidate;
    }

    public void setCandidate(Candidate candidate) {

        if (candidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null");
        }

        this.candidate = candidate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {

        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        this.status = status;
    }

    public List<String> getStatusHistory() {

        if (statusHistory == null) {
            throw new IllegalStateException("Status history not initialized");
        }

        return statusHistory;
    }

    public void setStatusHistory(List<String> statusHistory) {

        if (statusHistory == null) {
            throw new IllegalArgumentException("Status history cannot be null");
        }

        this.statusHistory = statusHistory;
    }

    @Override
    public String toString() {

        try {

            return "Candidate: " + candidate.getFullName() + ", Status: " + status;

        } catch (Exception e) {

            return "Application data corrupted";

        }
    }
}