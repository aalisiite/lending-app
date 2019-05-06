package lendingapp.demo.api;

import java.util.Objects;

public class Costumer {
    private Long Id;
    private String email;
    private String password;

    public Costumer(Long Id, String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Costumer(){
        
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
        if (!(o instanceof Costumer)) return false;
        Costumer customer = (Costumer) o;
        return email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
