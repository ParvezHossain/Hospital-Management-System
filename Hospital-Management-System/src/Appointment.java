/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Parvez
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAppointmentByDoctor", query = "from Appointment where assignedDoctor = :assignedDoctor")
    ,
	@NamedQuery(name = "findAppointmentByPatient", query = "from Appointment where assignedPatient = :assignedPatient")
    ,
	@NamedQuery(name = "findAppointmentByDoctorAndPatient", query = "from Appointment where assignedDoctor = :assignedDoctor and assignedPatient = :assignedPatient")
    ,
	@NamedQuery(name = "findAppointmentByDate", query = "from Appointment where appointmentDate = :appointmentDate")
    ,
	@NamedQuery(name = "findAppointmentByPatientAndDate", query = "from Appointment where assignedPatient = :assignedPatient and appointmentDate = :appointmentDate")
    ,
	@NamedQuery(name = "findAllAppointments", query = "from Appointment"),})
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    @Type(type = "calendar_date")
    @Column(name = "appointmentDate")
    private Calendar appointmentDate;

    @ManyToOne
    @JoinColumn(name = "assignedPatient")
    private Patient assignedPatient;

    @ManyToOne
    @JoinColumn(name = "assignedDoctor")
    private Doctor assignedDoctor;

    /**
     * Gets appointment id
     *
     * @return appointmentId
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * Gets appointment date
     *
     * @return appointmentDate
     */
    public Calendar getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Sets appointment date
     *
     * @param appointmentDate date for appointment
     */
    public void setAppointmentDate(Calendar appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets assigned doctor for appointment
     *
     * @return assignedDoctor
     */
    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    /**
     * Sets doctor for appointment
     *
     * @param assignedDoctor doctor for appointment
     */
    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    /**
     * Gets patient for appointment
     *
     * @return assignedPatient
     */
    public Patient getAssignedPatient() {
        return assignedPatient;
    }

    /**
     * Sets patient for appointment
     *
     * @param assignedPatient patient who has appointment
     */
    public void setAssignedPatient(Patient assignedPatient) {
        this.assignedPatient = assignedPatient;
    }

    /**
     * Formats appointment for printout
     */
    public String toString() {
        return "Appointment on " + (getAppointmentDate().get(2) + 1) + "/" + getAppointmentDate().get(5) + "/" + getAppointmentDate().get(1) + " with " + getAssignedDoctor();
    }
}
