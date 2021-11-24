package com.example.demoapi.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {
    
    @NotNull
    @Size(min = 2, max = 30)
    String firstname;
    
    @NotNull
    @Size(min = 2, max = 30)
    String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
}
