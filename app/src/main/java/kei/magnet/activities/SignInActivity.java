package kei.magnet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.AbstractMap;
import kei.magnet.JSONTask;
import kei.magnet.R;
import kei.magnet.classes.ApplicationUser;
import kei.magnet.task.SignInTask;

public class SignInActivity extends AppCompatActivity {
    private EditText txtLogin;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtLogin = (EditText) findViewById(R.id.sign_in_editText_LOGIN);
        txtPassword = (EditText) findViewById(R.id.sign_in_editText_PASSWORD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick_submit(View V) {
        SignInTask task = new SignInTask(this);
        task.execute(new AbstractMap.SimpleEntry<>("login", txtLogin.getText().toString()),
                     new AbstractMap.SimpleEntry<>("password", txtPassword.getText().toString()));
    }

    public void onClick_signUp(View v){
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }
}
