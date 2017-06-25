package kr.ztz.kal.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import kr.ztz.kal.R;
import kr.ztz.kal.Utils;

public class CreateActivity extends AppCompatActivity {

    private EditText etNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etNickname = (EditText) findViewById(R.id.et_nickname);
        String nickname = etNickname.getText().toString();
        String uuid = Utils.getDeviceUUID(this);



    }


}
