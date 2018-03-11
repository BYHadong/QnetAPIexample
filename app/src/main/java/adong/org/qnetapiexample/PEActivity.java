package adong.org.qnetapiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import adong.org.qnetapiexample.data.Item;
import adong.org.qnetapiexample.data.PEResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PEActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_pe);
        init();
        apiService = RetrofitAPI.retrofit.create(APIService.class);
        call = apiService.getPEResult();
        call.enqueue(new Callback<PEResult>() {
            @Override
            public void onResponse(Call<PEResult> call, Response<PEResult> response) {
                item = response.body().getResponse().getBody().getItems().getItem().get(0);
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
        description = findViewById(R.id.description);
        docregstartdt = findViewById(R.id.docregstartdt);
        docregenddt = findViewById(R.id.docregenddt);
        docexamdt = findViewById(R.id.docexamdt);
        docpassdt = findViewById(R.id.docpassdt);
        docsubmitstartdt = findViewById(R.id.docsubmitstartdt);
        docsubmitendt = findViewById(R.id.docsubmitendt);
        pracregstartdt = findViewById(R.id.pracregstartdt);
        pracregenddt = findViewById(R.id.pracregenddt);
        pracexamstartdt = findViewById(R.id.pracexamstartdt);
        pracexamenddt = findViewById(R.id.pracexamenddt);
        pracpassdt = findViewById(R.id.pracpassdt);
    }

    public String chnum(String chString){
        String yy = chString.substring(0,4)+"년 ";
        String MM = chString.substring(4,6)+"월 ";
        String dd = chString.substring(6,8)+"일";
        chString = yy+MM+dd;
        return chString;
    }
}
