package ml.univ.moviefinder;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import ml.univ.moviefinder.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MovieFinder";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.btnSearch.setOnClickListener(v -> onSearchClicked());
    }

    private void onSearchClicked() {
        String query = binding.etQuery.getText().toString().trim();
        if (query.isEmpty()) {
            binding.etQuery.setError(getString(R.string.msg_empty));
            return;
        }
        Log.d(TAG, "Recherche : " + query);
        binding.tvMessage.setText(getString(R.string.msg_searching, query));
    }
}
