package com.example.diffutilrv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * ViewModel for represent a employee list.
 * <p>
 * ViewModel:
 * <p>
 * - Manipulated by user actions.
 * <p>
 * - Defines 'How the data build up'.
 * <p>
 * - Publish data to View by using LiveData.
 */
public class EmployeesViewModel extends ViewModel {
    private final List<Employee> employees = new ArrayList<>(); // Immutable list reference.
    private SortingRule sortingRule = SortingRule.NAME;
    private final MutableLiveData<List<Employee>> employeeLiveData = new MutableLiveData<>();

    /**
     * Expose immutable LiveData.
     */
    public LiveData<List<Employee>> employee() {
        return employeeLiveData;
    }

    /**
     * For fetching data by sorting current rule.
     */
    public void fetch() {
        CompletableFuture.runAsync(this::loadEmployees);
    }

    public void sortByName() {
        updateSortingRule(SortingRule.NAME);
    }

    public void sortByRole() {
        updateSortingRule(SortingRule.ROLE);
    }

    private void updateSortingRule(SortingRule rule) {
        sortingRule = rule;
        loadEmployees();
    }

    private void loadEmployees() {
        CompletableFuture.runAsync(() -> {
            switch (sortingRule) {
                case NAME:
                    loadEmployees(DummyEmployeeDataUtils.getEmployeeListSortedByName());
                    break;
                case ROLE:
                    loadEmployees(DummyEmployeeDataUtils.getEmployeeListSortedByRole());
                    break;
            }
        });
    }

    private void loadEmployees(List<Employee> newEmployees) {
        employees.clear();
        employees.addAll(newEmployees);
        employeeLiveData.postValue(employees);
    }
}
