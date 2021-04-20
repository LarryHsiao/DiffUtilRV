package com.example.diffutilrv;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Entry point of this app.
 */
public class MainActivity extends AppCompatActivity {
    // Immutable adapter, why: One list, one adapter. Make sense?
    private final EmployeeAdapter mAdapter = new EmployeeAdapter();
    private EmployeesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.loadList(DummyEmployeeDataUtils.getEmployeeListSortedByRole());
        viewModel = ViewModelProviders.of(this).get(EmployeesViewModel.class);
        viewModel.employee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                mAdapter.loadList(employees);
            }
        });
        viewModel.fetch();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort_by_name) {
            viewModel.sortByName();
        } else if (item.getItemId() == R.id.sort_by_role) {
            viewModel.sortByRole();
        }
        return super.onOptionsItemSelected(item);
    }
}
