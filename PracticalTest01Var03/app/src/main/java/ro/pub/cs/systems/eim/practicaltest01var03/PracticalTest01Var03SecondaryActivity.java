package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    Button buttonCorrect;
    Button buttonIncorrect;
    TextView textViewSecond;


    private GenericButton genericButtonClickListener = new GenericButton();
    private class GenericButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonCorrect:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.buttonIncorrect:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        textViewSecond = (TextView)findViewById(R.id.textViewSecond);

        buttonCorrect = (Button)findViewById(R.id.buttonCorrect);
        buttonCorrect.setOnClickListener(genericButtonClickListener);

        buttonIncorrect = (Button)findViewById(R.id.buttonIncorrect);
        buttonIncorrect.setOnClickListener(genericButtonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("textView")) {
            String operation = intent.getStringExtra("textView");
            textViewSecond.setText(operation);
        }
    }
}
