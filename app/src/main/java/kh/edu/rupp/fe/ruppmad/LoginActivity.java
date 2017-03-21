package kh.edu.rupp.fe.ruppmad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

    private final String USERNAME = "rupp-fe";
    private final String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            EditText etxtUsername = (EditText) findViewById(R.id.etxt_username);
            String username = etxtUsername.getText().toString();
            EditText etxtPassword = (EditText) findViewById(R.id.etxt_password);
            String password = etxtPassword.getText().toString();
            if (username.equals(USERNAME) && password.equals(PASSWORD)){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
            }
        }
    }
}
