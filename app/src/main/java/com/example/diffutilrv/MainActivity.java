package com.example.diffutilrv;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Entry point of this app.
 */
public class MainActivity extends AppCompatActivity {
    private final EmployeeAdapter mAdapter = new EmployeeAdapter(); // Immutable adapter, why: One list, one adapter. Make sense?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.loadList(DummyEmployeeDataUtils.getEmployeeListSortedByRole());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort_by_name) {
            mAdapter.loadList(
                    DummyEmployeeDataUtils.getEmployeeListSortedByName());
        } else if (item.getItemId() == R.id.sort_by_role) {
            mAdapter.loadList(
                    DummyEmployeeDataUtils.getEmployeeListSortedByRole());
        }
        return super.onOptionsItemSelected(item);
    }
}
