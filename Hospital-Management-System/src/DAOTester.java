/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.GregorianCalendar;

/**
 *
 * @author Parvez
 */
public class DAOTester {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Doctor d1 = new Doctor();
        d1.setName("Doctor Lee");
        d1.setSpecialty("Surgeon");

        Doctor d2 = new Doctor();
        d2.setName("Dummy Doctor");
        d2.setSpecialty("Specialty");

        Patient p1 = new Patient();
        p1.setName("John Smith");
        p1.setDOB(new GregorianCalendar().getInstance()); //year month day where month starts from 0

        Patient p2 = new Patient();
        p2.setName("Dummy Patient");
        p2.setDOB(new GregorianCalendar().getInstance()); //year month day where month starts from 0

        Prescription prescription = new Prescription();
        prescription.setDoctor(d1);
        prescription.setPatient(p1);
        prescription.setMedicationName("Med #1");

        Appointment appointment = new Appointment();
        appointment.setAssignedDoctor(d1);
        appointment.setAssignedPatient(p1);
        appointment.setAppointmentDate(new GregorianCalendar().getInstance());

        d1.addAppointment(appointment);
        d1.addPatient(p1);

        MedicalDAO medicalDAO = new ConcreteMedicalDAO();

        /* test creation */
        medicalDAO.create(d1);
        medicalDAO.create(d2);
        medicalDAO.create(p2);
        medicalDAO.create(prescription);
        medicalDAO.create(appointment);

        /* test retrieve */
        medicalDAO.findDoctorByName("Micheal Lee");
        medicalDAO.findDoctorBySpecialty("Surgeon");
        medicalDAO.findPatientByNameAndDOB("John Smith", new GregorianCalendar().getInstance());

        /* test deletion - delete a dummy doctor and dummy patient */
//		medicalDAO.delete(d2);
//		medicalDAO.delete(p2);
//		medicalDAO.findAppointmentByDoctor("Michael Lee");
        /* find all x */
//		System.out.println("Doctors: " + medicalDAO.findAllDoctors());
//		System.out.println("Patients: " + medicalDAO.findAllPatients());
//		System.out.println("Prescriptions: " + medicalDAO.findAllPrescriptions());
//		System.out.println("Appointments: " + medicalDAO.findAllAppointments());
        medicalDAO.closeSessionFactory();
    }

}
