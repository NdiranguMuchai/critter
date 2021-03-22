package com.udacity.jdnd.course3.critter.model;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "employee")
public class Employee extends DetailsHandler {
    @Transient
    private Set<EmployeeSkill> skills = new HashSet<>();
    @Transient
    private Set<DayOfWeek> daysAvailable = new HashSet<>();

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
