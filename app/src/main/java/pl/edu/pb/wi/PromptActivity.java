package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private int hint;
    private Button button;
    private TextView textView;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
        hint = getIntent().getIntExtra(MainActivity.KEY_EXTRA_HINT, 0);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int _hint = hint;
                textView.setText(_hint);
            }
        });

    }
}