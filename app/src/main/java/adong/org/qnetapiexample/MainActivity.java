package adong.org.qnetapiexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.pebutton)
    public void PEbutton(){
        Toast.makeText(this, "보여드리겠습니다.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), PEActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
