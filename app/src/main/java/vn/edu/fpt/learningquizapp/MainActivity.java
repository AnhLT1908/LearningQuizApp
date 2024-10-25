package vn.edu.fpt.learningquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView; // Ensure to define the type for the navigation view
    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.my_drawer);
        navigationView = findViewById(R.id.navigation_view);

        // Set up the ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Enable the up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        // Set up the BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        // Set the navigation item selected listener
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Check which menu item was selected
        if (menuItem.getItemId() == R.id.pdf) {
            Toast.makeText(this, "eBooks", Toast.LENGTH_SHORT).show();
        } else if (menuItem.getItemId() == R.id.share) {
            Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show();
        } else if (menuItem.getItemId() == R.id.rate) {
            Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
        } else if (menuItem.getItemId() == R.id.about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        } else {
            return false; // Return false for any unrecognized item
        }
        return true; // Return true if an item was successfully handled
    }


}
