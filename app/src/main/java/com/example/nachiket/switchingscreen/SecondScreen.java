package com.example.nachiket.switchingscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nachiket on 8/13/2014.
 */
public class SecondScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        Intent activityThatCalled = getIntent();

        //String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        Human bob = (Human) activityThatCalled.getSerializableExtra("Human");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        //callingActivityMessage.append(" " + previousActivity);
        callingActivityMessage.append(bob.getName() + " " + bob.getHeight() + " ft" + bob.getWeight() + " lbs");
    }

    public void onSendUserName(View view) {

        EditText userNameET = (EditText) findViewById(R.id.user_name_edit_text);

        String usersName = String.valueOf(userNameET.getText());
        Intent goingBack = new Intent();
        goingBack.putExtra("Usersname", usersName);
        setResult(RESULT_OK, goingBack);
        finish();
    }
}
