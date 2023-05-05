package com.example.testopensw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class server_upload extends AppCompatActivity {
    EditText server_child,server_value;
    TextView pre_text;
    Button upload;

    private DatabaseReference mdatabase; //데이터베이스 불러오기위한 선언
    //이거 쓰려면 firebase에서 연동해서 파일넣고 gradle에 sdk 플러그인 추가하고 import까지해야함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_upload);

        pre_text=findViewById(R.id.textView);
        server_child=(EditText)findViewById(R.id.edittext_child);
        server_value=(EditText)findViewById(R.id.edittext_value);
        upload=findViewById(R.id.button); //레이아웃의 인자들 변수

        Intent intent=getIntent();//액티비이동할떄 넘어온 intent받기
        pre_text.setText(intent.getStringExtra("sending_value"));//intent안에 "sending_value"값 불러와서 pre_text값 설정

        upload.setOnClickListener((new View.OnClickListener() {//버튼이벤트
            @Override
            public void onClick(View view) {
                String upload_child=server_child.getText().toString();
                String upload_value=server_value.getText().toString();//서버에 업로드를 위해 값받고 형변환

                mdatabase = FirebaseDatabase.getInstance().getReference();//데이터베이스 호출
                mdatabase.child(upload_child).setValue(upload_value);//데이터베이스에 upload_child:upload_value형태로 저장됨
                // 이때 child에 있는건 항목이고 setValue에 있는건 값인데 항목에서 띄어쓰기인가 특수문자 몇개는 설정할수 없음
            }
        }));




    }
}