package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonNavigate;

    private EditText editText1;
    private EditText editText2;
    private TextView textView;

    private PlusButtonClickListener plusButtonClickListener = new PlusButtonClickListener();
    private class PlusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Integer result = 0;
            try {
                Integer no1 = Integer.parseInt(editText1.getText().toString());
                Integer no2 = Integer.parseInt(editText2.getText().toString());
                result = no1 + no2;
                textView.setText(editText1.getText().toString() + " + " + editText2.getText().toString() + " = " + result);
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Intoduceti numerel corect",Toast.LENGTH_SHORT).show();
            }

            // phoneNumberEditText.setText(phoneNumberEditText.getText().toString() + ((Button)view).getText().toString());
        }
    }

    private MinusButtonClickListener minusButtonClickListener = new MinusButtonClickListener();
    private class MinusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Integer result = 0;
            try {
                Integer no1 = Integer.parseInt(editText1.getText().toString());
                Integer no2 = Integer.parseInt(editText2.getText().toString());
                result = no1 - no2;
                textView.setText(editText1.getText().toString() + " - " + editText2.getText().toString() + " = " + result);
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Intoduceti numerel corect",Toast.LENGTH_SHORT).show();
            }

            // phoneNumberEditText.setText(phoneNumberEditText.getText().toString() + ((Button)view).getText().toString());
        }
    }

    private NavigateButtonClickListener navigateButtonClickListener = new NavigateButtonClickListener();
    private class NavigateButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
            intent.putExtra("textView", textView.getText().toString());
            startActivityForResult(intent, 1998);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*String s = "AJUNGEEE AICIIII";
        Log.i("activitylifecycle", "AJUNGEEE AICIIII\n\n\n\nAAAAAAAAA");*/
        if(requestCode == 1998) {
            if (resultCode == RESULT_OK) {
                String s = "AJUNGEEE AICIIII";
                Log.i("activitylifecycle", "AJUNGEEE AICIIII\n\n\n\nAAAAAAAAA");
                Toast.makeText(getApplicationContext(),"Rezultat corect",Toast.LENGTH_SHORT).show();
            } else {
                String s = "AJUNGEEE AICIIII";
                Log.i("activitylifecycle", "AJUNGEEE AICIIII\n\n\n\nBBBBBBB");
                Toast.makeText(getApplicationContext(),"Rezultat Incorect",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        textView = (TextView)findViewById(R.id.textView);

        buttonPlus = (Button)findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(plusButtonClickListener);

        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(minusButtonClickListener);

        buttonNavigate = (Button)findViewById(R.id.secondActivity);
        buttonNavigate.setOnClickListener(navigateButtonClickListener);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("textView")) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(savedInstanceState.getString("textView"));
            }

            if (savedInstanceState.containsKey("editText1")) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                editText1.setText(savedInstanceState.getString("editText1"));
            }

            if (savedInstanceState.containsKey("editText2")) {
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                editText2.setText(savedInstanceState.getString("editText2"));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        TextView textView = (TextView) findViewById(R.id.textView);
        savedInstanceState.putString("textView", textView.getText().toString());
        if (savedInstanceState.containsKey("textView")) {
            TextView text = (TextView) findViewById(R.id.textView);
            textView.setText(savedInstanceState.getString("textView"));
        }

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        savedInstanceState.putString("editText1", editText1.getText().toString());
        if (savedInstanceState.containsKey("editText1")) {
            EditText text = (EditText) findViewById(R.id.editText1);
            editText1.setText(savedInstanceState.getString("editText1"));
        }

        EditText editText2 = (EditText) findViewById(R.id.editText2);
        savedInstanceState.putString("editText2", editText2.getText().toString());
        if (savedInstanceState.containsKey("editText2")) {
            EditText editText = (EditText) findViewById(R.id.editText2);
            editText2.setText(savedInstanceState.getString("editText2"));
        }



    }
}