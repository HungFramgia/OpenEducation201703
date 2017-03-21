package com.example.pbhhe.eventandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    //khai bao button
    private EditText edtMath;
    private TextView tvResult;
    private String ch = "";
    private Button so0;
    private Button so1;
    private Button so2;
    private Button so3;
    private Button so4;
    private Button so5;
    private Button so6;
    private Button so7;
    private Button so8;
    private Button so9;

    private Button dauCong;
    private Button dauTru;
    private Button dauNhan;
    private Button dauChia;
    private Button dauBang;

    private Button dauCham;
    private Button Clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initWidget();
        setEventClickView();
    }

    public void initWidget(){
        edtMath = (EditText) findViewById(R.id.edtMath);
        tvResult = (TextView) findViewById(R.id.tvResult);

        so0 = (Button) findViewById(R.id.so0);
        so2 = (Button) findViewById(R.id.so2);
        so3 = (Button) findViewById(R.id.so3);
        so4 = (Button) findViewById(R.id.so4);
        so5 = (Button) findViewById(R.id.so5);
        so6 = (Button) findViewById(R.id.so6);
        so7 = (Button) findViewById(R.id.so7);
        so8 = (Button) findViewById(R.id.so8);
        so9 = (Button) findViewById(R.id.so9);
        so1 = (Button) findViewById(R.id.so1);

        dauBang = (Button) findViewById(R.id.daubang);
        dauCong = (Button) findViewById(R.id.daucong);
        dauTru = (Button) findViewById(R.id.dautru);
        dauNhan = (Button) findViewById(R.id.daunhan);
        dauChia = (Button) findViewById(R.id.dauchia);

        dauCham = (Button) findViewById(R.id.daucham);
        Clear = (Button) findViewById(R.id.clear);
    }

    public void setEventClickView(){
        so0.setOnClickListener(this);
        so1.setOnClickListener(this);
        so2.setOnClickListener(this);
        so3.setOnClickListener(this);
        so4.setOnClickListener(this);
        so5.setOnClickListener(this);
        so6.setOnClickListener(this);
        so7.setOnClickListener(this);
        so8.setOnClickListener(this);
        so9.setOnClickListener(this);

        dauCong.setOnClickListener(this);
        dauTru.setOnClickListener(this);
        dauNhan.setOnClickListener(this);
        dauChia.setOnClickListener(this);
        dauCham.setOnClickListener(this);

        dauBang.setOnClickListener(this);
        Clear.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.daucham:
                edtMath.append(".");
                break;
            case R.id.so0:
                edtMath.append("0");
                break;
            case R.id.so1:
                edtMath.append("1");
                break;
            case R.id.so2:
                edtMath.append("2");
                break;
            case R.id.so3:
                edtMath.append("3");
                break;
            case R.id.so4:
                edtMath.append("4");
                break;
            case R.id.so5:
                edtMath.append("5");
                break;
            case R.id.so6:
                edtMath.append("6");
                break;
            case R.id.so7:
                edtMath.append("7");
                break;
            case R.id.so8:
                edtMath.append("8");
                break;
            case R.id.so9:
                edtMath.append("9");
                break;
            case R.id.dauchia:
                edtMath.append("/");
                break;
            case R.id.daucong:
                edtMath.append("+");
                break;
            case R.id.dautru:
                edtMath.append("-");
                break;
            case R.id.daunhan:
                edtMath.append("*");
                break;
            case R.id.clear:
                edtMath.setText("");
                break;
            case R.id.daubang:
                //Lam gon ket qua
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(edtMath.getText().toString());
                addNumber(edtMath.getText().toString());
                // Thuật toán tính toán biểu thức
                if(arrOperation.size()>=arrNumber.size() || arrOperation.size()<1){
                    tvResult.setText("Lỗi định dạng");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText(df.format(result) + "");
                }

                break;
        }
    }
    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
    // Chua xu ly dau ngoac

}
