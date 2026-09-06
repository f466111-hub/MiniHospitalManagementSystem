
public class TestHospitalSystem {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   MINI HOSPITAL SYSTEM TESTING");
        System.out.println("======================================");

        HospitalSystem hospital = new HospitalSystem();

        Patient p1 = new Patient(
                1003,
                "Kamal",
                45,
                "0771234567",
                "Heart Problem"
        );

        Patient p2 = new Patient(
                1001,
                "Ayesha",
                30,
                "0772345678",
                "Fever"
        );

        Patient p3 = new Patient(
                1002,
                "Nimal",
                55,
                "0773456789",
                "Diabetes"
        );

        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        System.out.println("\n--- BST Test: In-Order Traversal ---");
        hospital.displayAllPatients();

        System.out.println("\n--- BST Test: Search Patient ---");

        Patient foundPatient = hospital.findPatient(1002);

        if (foundPatient != null) {
            System.out.println("Patient found: "
                    + foundPatient.getPatientName());
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\n--- Queue Test ---");

        hospital.addEmergencyPatient(1001);
        hospital.addEmergencyPatient(1002);
        hospital.addEmergencyPatient(1003);

        hospital.displayEmergencyQueue();

        System.out.println("\nCalling next patient:");

        Patient nextPatient = hospital.callNextEmergencyPatient();

        if (nextPatient != null) {
            System.out.println(
                    "Next patient: "
                    + nextPatient.getPatientName()
            );
        }

        System.out.println("\n--- Stack Test ---");

        TreatmentRecord treatment1 = new TreatmentRecord(
                501,
                1001,
                "Ayesha",
                "Dr. Silva",
                "Fever",
                "Medication",
                "2026-09-01"
        );

        TreatmentRecord treatment2 = new TreatmentRecord(
                502,
                1002,
                "Nimal",
                "Dr. Perera",
                "Diabetes",
                "Insulin Treatment",
                "2026-09-02"
        );

        hospital.addTreatment(treatment1);
        hospital.addTreatment(treatment2);

        hospital.displayTreatmentHistory();

        System.out.println("\nRemoving latest treatment:");

        TreatmentRecord latestTreatment
                = hospital.removeLatestTreatment();

        if (latestTreatment != null) {
            System.out.println(
                    "Removed treatment ID: "
                    + latestTreatment.getTreatmentId()
            );
        }

        System.out.println("\n--- Linked List Test ---");

        Visit visit1 = new Visit(
                701,
                "2026-09-01",
                "Dr. Silva",
                "Fever",
                "Medication"
        );

        Visit visit2 = new Visit(
                702,
                "2026-09-03",
                "Dr. Perera",
                "Follow-up",
                "Check-up"
        );

        hospital.addVisit(1001, visit1);
        hospital.addVisit(1001, visit2);

        hospital.displayVisitHistory(1001);

        System.out.println("\nSearching Visit 702:");

        Visit foundVisit = hospital.searchVisit(1001, 702);

        if (foundVisit != null) {
            System.out.println(
                    "Visit found: "
                    + foundVisit.getVisitId()
            );
        } else {
            System.out.println("Visit not found.");
        }

        System.out.println("\nRemoving Visit 701:");

        hospital.removeVisit(1001, 701);

        hospital.displayVisitHistory(1001);

        System.out.println("\n======================================");
        System.out.println("       ALL TESTS COMPLETED");
        System.out.println("======================================");
    }
}
