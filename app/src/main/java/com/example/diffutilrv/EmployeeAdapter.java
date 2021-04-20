package com.example.diffutilrv;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for displaying a employee list.
 * <p>
 * Thought:
 * <p>
 * - Define 'How a item display'.
 * <p>
 * - So any manipulation of data should not shows up at here. (No if-else expression.)
 */
public class EmployeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * Immutable array reference for not using same list outside the adapter.
     * Make the data more controllable.
     */
    private final List<Employee> employees = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * I use anonymous ViewHolder object because I think the static internal class is redundant.
         * And it will make a pain in the ass passing all our object from adapter to the viewHolder,
         * which I think is redundant, too.
         */
        return new RecyclerView.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item, parent, false)
        ) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Employee employee = employees.get(position);
        /**
         * Straight forward code for setting up View, we can user some extension here to simplify the code in Kotlin.
         */
        ((TextView) holder.itemView.findViewById(R.id.employee_name)).setText(employee.getName());
        ((TextView) holder.itemView.findViewById(R.id.employee_role)).setText(employee.getRole());
    }

    /**
     * Load up entire list.
     */
    public void loadList(List<Employee> newEmployees) {
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(
                new EmployeeDiffCallback(this.employees, newEmployees)
        );
        this.employees.clear();
        this.employees.addAll(newEmployees);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
