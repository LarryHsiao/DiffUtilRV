package com.example.diffutilrv;

import java.util.Objects;

/**
 * Employee object presents a employee.
 */
public class Employee {
    public final int id;
    public final String name;
    public final String role;

    public Employee(final int id, final String name, final String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Employee employee = (Employee) obj;
        if (id != employee.id) {
            return false;
        }
        if (!role.equalsIgnoreCase(employee.role)) {
            return false;
        }
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = result + (name != null ? name.hashCode() : 0);
        result = result + role.hashCode();
        return result;
    }
}
