package lendingapp.demo.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegistrationRequest {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 6)
    private String password;

    @JsonCreator
    public RegistrationRequest(@JsonProperty("email") @NotEmpty @Email String email,
                               @JsonProperty("password") @NotEmpty String password) {
        this.email = email;
        this.password = password;
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
}
