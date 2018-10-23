package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "APP", name = "DEPARTMENT")
@NamedQueries({
        @NamedQuery(name = "department.readAll",
                query = "select p from Department p"),

        @NamedQuery(name = "department.readById",
                query = "select p from Department p where p.id = :id"),

        @NamedQuery(name = "department.delete",
                query = "delete from Department AS d where d.id = :id"),

        @NamedQuery(name = "department.update",
                query = "UPDATE Department AS d SET d.name = :name WHERE d.id = :id ")
})
public class Department implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID")
    private List<Employee> employees;

    public Department() {

    }

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Department(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
