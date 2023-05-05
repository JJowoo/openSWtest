package com.example.testopensw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText text;
    TextView view;
    Button nextactivity; //레이아웃의 인자들 받을 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {//엑티비티 시작
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=findViewById(R.id.match_parent_textview);
        text=(EditText) findViewById(R.id.wrap_content_edittext);
        nextactivity=findViewById(R.id.button);  //변수=findViewById(R.id.레이아웃에서 설정한 id)

        text.addTextChangedListener(new TextWatcher() { //text 값이 바뀌는 이벤트에서 호출 함수
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                view.setText(editable.toString());
            }// 값바뀌면 view텍스트값 text에서 입력된값으로 변경
        });

        nextactivity.setOnClickListener(new View.OnClickListener() {//nextactivity버튼 눌렸을때 이벤트함수
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,server_upload.class);//엑티비티이동 intent설정 (현재액티비티,이동할엑티비티)
                String value=text.getText().toString(); //text의 내용 가져가기위해 getText쓰고 toString으로 형변환
                intent.putExtra("sending_value",value); //다음엑티비티로 값 넘기기위해 intent에 값 삽입("값이름",값)

                startActivity(intent); //다음엑티비티 시작

            }
        });



    }
}