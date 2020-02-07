package sample;

import java.util.UUID;

public class Employee implements Worker {

    public String firstName;
    public String lastName;
    public boolean isActive;
    public UUID id;

    public Employee()
    {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString()
    {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void hire()
    {
        isActive = true;
    }

    @Override
    public void fire()
    {
        isActive = false;
    }
}
