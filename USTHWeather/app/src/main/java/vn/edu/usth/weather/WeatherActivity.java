package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter weatherPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);

        weatherPagerAdapter
                = new WeatherPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.weather_pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(weatherPagerAdapter);
        tabLayout = findViewById(R.id.weather_tab);
        for (int i = 0; i < weatherPagerAdapter.getCount(); i++) {
            tabLayout.addTab(
                    tabLayout.newTab().setText(
                            weatherPagerAdapter.getPageTitle(i)));
        }
        tabLayout.setupWithViewPager(viewPager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Weather", "onStart here");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Weather", "onResume here");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Weather", "onPause here");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Weather", "onStop here");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Weather", "onDestroy here");
    }
}