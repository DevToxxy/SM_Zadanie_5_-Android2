package pl.edu.pb.wi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private int questionId;
    private boolean trueAnswer;
    private int hintId;


    public Question(int questionId, boolean trueAnswer,int hintId) {
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
        this.hintId = hintId;
    }
}
