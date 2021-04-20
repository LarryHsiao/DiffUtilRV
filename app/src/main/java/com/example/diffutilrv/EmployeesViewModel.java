package com.example.diffutilrv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * ViewModel for represent a employee list.
 */
public class EmployeesViewModel extends ViewModel {
    private final List<Employee> employees = new ArrayList<>(); // Immutable list reference.
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
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                employees.clear();
                employees.addAll(fetchEmployees());
                employeeLiveData.postValue(employees);
            }
        });
    }

    public void sortByName(){
        // TODO
    }

    public void sortByRole(){
        // TODO
    }

    private List<Employee> fetchEmployees(){
        // TODO rule
        return DummyEmployeeDataUtils.getEmployeeListSortedByName();
    }
}
