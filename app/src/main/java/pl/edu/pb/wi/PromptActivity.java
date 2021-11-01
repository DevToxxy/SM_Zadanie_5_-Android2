package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private int hint;
    private Button hintButton;
    private TextView hintTextView;
    public static final String KEY_EXTRA_HINT_SHOWN = "hintShown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        hintButton = findViewById(R.id.hint_button);
        hintTextView = findViewById(R.id.hint_text_view);
        hint = getIntent().getIntExtra(MainActivity.KEY_EXTRA_HINT, 0);

        hintButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int _hint = hint;
                hintTextView.setText(_hint);
                setHintShownResult(true);
            }
        });
    }
    private void setHintShownResult(boolean hintWasShown){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_HINT_SHOWN,hintWasShown);
        setResult(RESULT_OK, resultIntent);
    }
}