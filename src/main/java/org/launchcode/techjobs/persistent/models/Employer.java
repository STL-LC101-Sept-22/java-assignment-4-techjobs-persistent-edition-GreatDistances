package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @OneToMany(mappedBy = "employer") // TODO is this mapping correct?  See part 3
    @JoinColumn
    private final List<Job> jobs = new ArrayList<>();

    @NotEmpty(message="Location field is required")
    @NotNull
    @Size(min=3, max=50, message="Location must be 3 to 50 characters")
    private String location;

    public Employer() {
    }

    public Employer(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
