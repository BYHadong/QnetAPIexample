package adong.org.qnetapiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import adong.org.qnetapiexample.PEdata.Item;
import adong.org.qnetapiexample.PEdata.PEResult;
import adong.org.qnetapiexample.Service.APIService;
import adong.org.qnetapiexample.Service.RetrofitAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NextPEActivity extends AppCompatActivity {

    APIService apiService;
    Call<PEResult> call;
    Item item;
    TextView pracregstartdt;
    TextView description;
    TextView docexamdt;
    TextView docpassdt;
    TextView docregenddt;
    TextView docregstartdt;
    TextView docsubmitendt;
    TextView docsubmitstartdt;
    TextView pracexamenddt;
    TextView pracexamstartdt;
    TextView pracpassdt;
    TextView pracregenddt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_pe);

        init();
        apiService = RetrofitAPI.retrofit.create(APIService.class);
        call = apiService.getPEResult();
        call.enqueue(new Callback<PEResult>() {
            @Override
            public void onResponse(Call<PEResult> call, Response<PEResult> response) {
                item = response.body().getResponse().getBody().getItems().getItem().get(1);
                description.setText(item.getDescription());
                docregstartdt.setText(chnum(item.getDocregstartdt()));
                docregenddt.setText(chnum(item.getDocregenddt()));
                docexamdt.setText(chnum(item.getDocexamdt()));
                docpassdt.setText(chnum(item.getDocpassdt()));
                docsubmitstartdt.setText(chnum(item.getDocsubmitstartdt()));
                docsubmitendt.setText(chnum(item.getDocsubmitentdt()));
                pracregstartdt.setText(chnum(item.getPracregstartdt()));
                pracregenddt.setText(chnum(item.getPracregenddt()));
                pracexamstartdt.setText(chnum(item.getPracexamstartdt()));
                pracexamenddt.setText(chnum(item.getPracexamenddt()));
                pracpassdt.setText(chnum(item.getPracpassdt()));
            }

            @Override
            public void onFailure(Call<PEResult> call, Throwable t) {

            }
        });
    }

    public void init(){
        description = findViewById(R.id.description1);
        docregstartdt = findViewById(R.id.docregstartdt1);
        docregenddt = findViewById(R.id.docregenddt1);
        docexamdt = findViewById(R.id.docexamdt1);
        docpassdt = findViewById(R.id.docpassdt1);
        docsubmitstartdt = findViewById(R.id.docsubmitstartdt1);
        docsubmitendt = findViewById(R.id.docsubmitendt1);
        pracregstartdt = findViewById(R.id.pracregstartdt1);
        pracregenddt = findViewById(R.id.pracregenddt1);
        pracexamstartdt = findViewById(R.id.pracexamstartdt1);
        pracexamenddt = findViewById(R.id.pracexamenddt1);
        pracpassdt = findViewById(R.id.pracpassdt1);
    }

    public String chnum(String chString){
        String yy = chString.substring(0,4)+"년 ";
        String MM = chString.substring(4,6)+"월 ";
        String dd = chString.substring(6,8)+"일";
        chString = yy+MM+dd;
        return chString;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "이전 시험 정보로 돌아갑니다.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
