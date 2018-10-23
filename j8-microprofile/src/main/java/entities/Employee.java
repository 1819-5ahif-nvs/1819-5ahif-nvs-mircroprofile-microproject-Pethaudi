package entities;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(schema = "APP", name = "EMPLOYEE")
@NamedQueries({
        @NamedQuery(name = "employee.readAll",
                query = "select p from Employee p"),

        @NamedQuery(name = "employee.readById",
                query = "select p from Employee p where p.id = :id")
})
public class Employee implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DATEOFBIRTH")
    private LocalDate dob;
    @Column(name = "DATEOFHIREMENT")
    private LocalDate dateOfHirement;
    @Column(name = "DATEOFQUITTING")
    private LocalDate dateOfQuitting;
    @ManyToOne
    private Department department;

    public Employee(){

    }

    public Employee(String name, String surname, LocalDate dob, LocalDate dateOfHirement, LocalDate dateOfQuitting, Department department) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dateOfHirement = dateOfHirement;
        this.dateOfQuitting = dateOfQuitting;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDateOfHirement() {
        return dateOfHirement;
    }

    public LocalDate getDateOfQuitting() {
        return dateOfQuitting;
    }

    public Department getDepartment() {
        return department;
    }
}

