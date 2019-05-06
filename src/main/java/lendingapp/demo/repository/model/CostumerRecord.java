package lendingapp.demo.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "costumers")
public class CostumerRecord {

    @Id
    @GeneratedValue(generator = "costumers_seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "costumers_seq_generator", sequenceName = "costumers_seq", allocationSize = 1)
    private Long Id;
    @NotEmpty
    @Column(name = "email")
    private String email;
    @NotEmpty
    @Column(name = "password")
    private String password;

    public CostumerRecord(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public CostumerRecord() {
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CostumerRecord)) return false;
        CostumerRecord that = (CostumerRecord) o;
        return Id.equals(that.Id) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, email);
    }
}
