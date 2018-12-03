package com.example.pan.myappone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_show;
    private EditText et_text;
    private Button bt_clear_away, bt_clear, bt_equ, bt_per, bt_dot; // 清除，删除，等于，百分号，点
    private Button bt_addition, bt_sub, bt_mul, bt_div;   // 加减乘除
    private Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9;
    private double two;  //TextView输入的数值
    private double one;  //EditText输入的数值
    private String getEditTextString; //得到EditText字符串
    private String getTextViewString; //得到TextView字符串
    private String getOperationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        et_text = (EditText) findViewById(R.id.et_text);
        bt_clear_away = (Button) findViewById(R.id.bt_clear_away);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        bt_equ = (Button) findViewById(R.id.bt_equ);
        bt_per = (Button) findViewById(R.id.bt_per);
        bt_dot = (Button) findViewById(R.id.bt_dot);
        bt_addition = (Button) findViewById(R.id.bt_addition);
        bt_sub = (Button) findViewById(R.id.bt_sub);
        bt_mul = (Button) findViewById(R.id.bt_mul);
        bt_div = (Button) findViewById(R.id.bt_div);
        bt_0 = (Button) findViewById(R.id.bt_0);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
        bt_9 = (Button) findViewById(R.id.bt_9);
        ButtonOnClick();
    }

    private void ButtonOnClick() {
        bt_clear_away.setOnClickListener(this);
        bt_clear.setOnClickListener(this);
        bt_equ.setOnClickListener(this);
        bt_per.setOnClickListener(this);
        bt_dot.setOnClickListener(this);
        bt_addition.setOnClickListener(this);
        bt_sub.setOnClickListener(this);
        bt_mul.setOnClickListener(this);
        bt_div.setOnClickListener(this);
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getEditTextString = et_text.getText().toString();
        getTextViewString = tv_show.getText().toString();
        switch (v.getId()) {
            case R.id.bt_0:
                judge(bt_0);
                break;
            case R.id.bt_1:
                judge(bt_1);
                break;
            case R.id.bt_2:
                judge(bt_2);
                break;
            case R.id.bt_3:
                judge(bt_3);
                break;
            case R.id.bt_4:
                judge(bt_4);
                break;
            case R.id.bt_5:
                judge(bt_5);
                break;
            case R.id.bt_6:
                judge(bt_6);
                break;
            case R.id.bt_7:
                judge(bt_7);
                break;
            case R.id.bt_8:
                judge(bt_8);
                break;
            case R.id.bt_9:
                judge(bt_9);
                break;
            case R.id.bt_addition://加
                setOperation(bt_addition);
                break;
            case R.id.bt_sub://减
                setOperation(bt_sub);
                break;
            case R.id.bt_mul://乘
                setOperation(bt_mul);
                break;
            case R.id.bt_div://除
                setOperation(bt_div);
                break;
            case R.id.bt_equ://等于
                if (getEditTextString.equals("")) {
                    Toast.makeText(this, "没有数值输入", Toast.LENGTH_SHORT).show();
                    return;
                }  //判断文本框是否为空
                two = Double.parseDouble(getEditTextString);
                if (getTextViewString.contains("+")
                        || getTextViewString.contains("-")
                        || (getTextViewString.contains("*"))
                        || getTextViewString.contains("/")) {
                    setEqual();
                }
                break;
            case R.id.bt_clear_away:
                tv_show.setText("");
                et_text.setText("");
                break;
            case R.id.bt_clear://删除
                setDelete();
                break;
            case R.id.bt_dot://点
                setDot();
                break;
            case R.id.bt_per://百分比
                setPercent();
                break;
        }
    }

    /**
     * 设置百分比
     */
    private void setPercent() {
        if (getEditTextString.equals("")) {//判断文本框是否为空
            if (getTextViewString.equals("")) {
                Toast.makeText(this, "没有数值输入", Toast.LENGTH_SHORT).show();
                return;
            } else if (!getTextViewString.equals("")
                    && !(getTextViewString.contains("+")
                    || getTextViewString.contains("-")
                    || getTextViewString.contains("*")
                    || getTextViewString.contains("/"))) {
                String getTextViewNumber = getTextViewString;
                Double getDoubleNumber = Double.parseDouble(getTextViewNumber);
                Double a = getDoubleNumber / 100;
                tv_show.setText(String.valueOf(a));
            }
        } else if (getTextViewString.equals("")) {
            String getEditTextNumber = getEditTextString;
            Double getDoubleNumber = Double.parseDouble(getEditTextNumber);
            Double b = getDoubleNumber / 100;
            tv_show.setText(String.valueOf(b));
            et_text.setText("");
        } else {
            char operation = getTextViewString.charAt(getTextViewString.length() - 1);
            String a_str = getTextViewString.substring(0, getTextViewString.length() - 1);
            String b_str = getEditTextString;
            Double a_number = Double.parseDouble(a_str);
            Double b_number = Double.parseDouble(b_str);
            double c = 0;
            switch (operation) {
                case '+':
                    c = a_number + b_number;
                    break;
                case '-':
                    c = a_number - b_number;
                    break;
                case '*':
                    c = a_number * b_number;
                    break;
                case '/':
                    c = a_number / b_number;
                    break;
            }
            tv_show.setText(String.valueOf(c / 100));
            et_text.setText("");
        }
    }

    /**
     * 点按钮
     */
    private void setDot() {
        if (getEditTextString.equals("")) {
            Toast.makeText(this, "请输入数字后再点小数点", Toast.LENGTH_SHORT).show();
            return;
        }
//                String decimalPoint = getString.substring(getString.length() - 1);
        if (getEditTextString.contains(".")) {
            //如果输入框含有"."时，不能重复输入
            return;
        }
        String a = bt_dot.getText().toString();
        et_text.append(a);
    }

    /**
     * 删除按钮
     */
    private void setDelete() {
        int index = et_text.getSelectionStart();//删除光标前字符
        if (getEditTextString.length() != 0) {
            et_text.getText().delete(index - 1, index);
        } else if (getTextViewString.length() != 0) {
            String str = getTextViewString.substring(0, getTextViewString.length() - 1);
            if (str.contains(".")) {
                String str1 = str.substring(str.length() - 1, str.length());//截取最后一位
                if (str1.equals(".")) {
                    String str2 = str.substring(0, str.length() - 1);
                    tv_show.setText(str2);
                } else {
                    tv_show.setText(str);
                }
            } else {
                tv_show.setText(str);
            }
        }
    }

    /**
     * 判断是否为空
     *
     * @return
     */


    /**
     * 0-9 Button事件处理
     *
     * @param num_bt
     */
    private void judge(Button num_bt) {
        String getButtonText = num_bt.getText().toString();
        et_text.append(getButtonText);
        if (!getTextViewString.contains("+") && !getTextViewString.contains("-") && !getTextViewString.contains("*") && !getTextViewString.contains("/")) {
            tv_show.setText("");
        }
    }

    /**
     * "+" "-" "*" "/"  Button事件处理
     *
     * @param bt_a
     */
    private void setOperation(Button bt_a) {

        if (getEditTextString.equals("") && !getTextViewString.equals("")) {
            if (getTextViewString.contains("+")
                    || getTextViewString.contains("-")
                    || getTextViewString.contains("*")
                    || getTextViewString.contains("/")) {
                String str2 = getTextViewString.substring(0, getTextViewString.length() - 1);
                String str1 = bt_a.getText().toString();
                String str3 = str2 + str1;
                tv_show.setText(str3);
                return;
            } else {
                String str = bt_a.getText().toString();
                tv_show.append(str);
                return;
            }
        }
        if (getEditTextString.equals("") && getTextViewString.equals("")) {
            Toast.makeText(this, "请输入数字后再运算", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!getTextViewString.contains("+")
                && !getTextViewString.contains("-")
                && !getTextViewString.contains("*")
                && !getTextViewString.contains("/")) {
            getOperationButton = bt_a.getText().toString();
            one = Double.parseDouble(getEditTextString);
            tv_show.append(one + getOperationButton);
            et_text.setText("");
        } else {
//          bt_equ.performClick();  //执行点击按钮
            setRepetitionCount(bt_a);     //设置重复计算
        }
    }

    /**
     * 运算符重复计算
     *
     * @param bt_a
     */
    private void setRepetitionCount(Button bt_a) {
        String tem1 = getTextViewString.substring(getTextViewString.length() - 1);
        getNewStringText();
        switch (tem1) {
            case "+":
                getNewButtonText(bt_a, one + two);//重新获取button文本
                break;
            case "-":
                getNewButtonText(bt_a, one - two);
                break;
            case "*":
                getNewButtonText(bt_a, one * two);
                break;
            case "/":
                if (DivisorForZero()) break;
                getNewButtonText(bt_a, one / two);
                break;
        }
    }

    /**
     * 除数为零时提示信息
     * @return
     */
    private boolean DivisorForZero() {
        String str_two = Double.toString(two);
        if (str_two.equals("0.0")) {//当第二次输入为0时
            Toast.makeText(this, "0不能做除数", Toast.LENGTH_SHORT).show();
            et_text.setText("");
            return true;
        }
        return false;
    }

    /**
     * 重新获取button的text并显示
     *
     * @param bt_a
     * @param result
     */
    private void getNewButtonText(Button bt_a, Double result) {
        String str = bt_a.getText().toString();
        tv_show.setText(String.valueOf(result) + str);
    }

    /**
     * "="  等于号处理运算结果
     */
    private void setEqual() {
        String tem = getTextViewString.substring(getTextViewString.length() - 1);// 截取最后一个字串
        getNewStringText();// 从新获取数值
        switch (tem) {
            case "+":
                tv_show.setText(String.valueOf(one + two));
                break;
            case "-":
                tv_show.setText(String.valueOf(one - two));
                break;
            case "*":
                tv_show.setText(String.valueOf(one * two));
                break;
            case "/":
                if (DivisorForZero()) break; // 除数为零时
                tv_show.setText(String.valueOf(one / two));
                break;
        }
    }

    /**
     * 重新获取数值
     */
    private void getNewStringText() {
        String str3 = getTextViewString.substring(0, getTextViewString.length() - 1);//删除字符串最后一位字符
        one = Double.parseDouble(str3);
        two = Double.parseDouble(getEditTextString);
        et_text.setText("");
    }
}
