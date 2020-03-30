package kr.co.softcampus.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조변수
    EditText edit1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editText3);
        text1 = (TextView)findViewById(R.id.textView);

        EnterListner listner = new EnterListner();
        edit1.setOnEditorActionListener(listner);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);

    }

    public void btn1Method(View view){
        edit1.setText("새롭게 설정할 문자열");

    }

    public void btn2Method(View view){
        String str = edit1.getText().toString();   //string으로 반환하여 받는다
        text1.setText("입력한 문자열 : " + str);
    }

    class EnterListner implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

            String  str = textView.getText().toString();

            text1.setText("입력한 문자열 " + str);

            return false;
        }
    }

    //작성되고 있는 문자열을 화면에 보여주기 위한 클래스
    class WatcherClass implements TextWatcher{

        @Override
        // 문자열 값이 변경되었을 때
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            text1.setText("문자열 변경 중: " + s);

        }

        @Override
        //문자열 값이 변경되기 전
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        //문자열 값이 변경된 이후
        public void afterTextChanged(Editable s) {

        }


    }

}
