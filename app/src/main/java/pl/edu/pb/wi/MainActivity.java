package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;
    private static final String QUIZ_TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(QUIZ_TAG, "Wywołana metoda: onCreate");
        setContentView(R.layout.activity_main);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questions.length;
                setNextQuestion();
            }
        });
        setNextQuestion();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(QUIZ_TAG, "Wywołana metoda: onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(QUIZ_TAG, "Wywołana metoda: onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(QUIZ_TAG, "Wywołana metoda: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(QUIZ_TAG, "Wywołana metoda: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(QUIZ_TAG, "Wywołana metoda: onDestroy");

    }

    private Question[] questions = new Question[]{
            new Question(R.string.q_overlord, false),
            new Question(R.string.q_onepunch, true),
            new Question(R.string.q_note, true),
            new Question(R.string.q_abyss, true),
            new Question(R.string.q_hellsing, false),
            new Question(R.string.q_kaisen, false)
    };

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if (userAnswer == correctAnswer) {
            resultMessageId = R.string.correct_answer;
        } else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }


}