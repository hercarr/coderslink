package mx.hercarr.coderslink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.hercarr.coderslink.rest.CoderLinkResponse;
import mx.hercarr.coderslink.rest.CodersLinkAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtID;
    private TextView txtContent;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = (TextView) findViewById(R.id.txtID);
        txtContent = (TextView) findViewById(R.id.txtContent);
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        });

        sayHello();
    }

    private void sayHello() {
        Call<CoderLinkResponse> call = CodersLinkAPI.getHelloWordService().sayHello();
        call.enqueue(new Callback<CoderLinkResponse>() {
            @Override
            public void onResponse(Call<CoderLinkResponse> call, Response<CoderLinkResponse> response) {
                txtID.setText("ID: " + response.body().getId());
                txtContent.setText("Content: " + response.body().getContent());
            }

            @Override
            public void onFailure(Call<CoderLinkResponse> call, Throwable t) {
            }

        });
    }

}
