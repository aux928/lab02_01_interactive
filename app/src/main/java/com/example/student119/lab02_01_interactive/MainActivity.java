package com.example.student119.lab02_01_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mQuantity = 0;
    private int mPrice = 100 ;
    private final String mNT$ = "NT$";
    private StringBuilder mTotalPriceMessage = new StringBuilder(mNT$);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public  void submitOrder(View view) {
        displayTotalPrice();
    }
    private void displayTotalPrice(){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int startIndex = mNT$.length();
        int endIndex = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex,endIndex).append(total)
                .append(mQuantity ==0 ? "\nFree" : "\nThank you !");
        priceTextView.setText( mTotalPriceMessage);
    }
    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }


    public void increment(View view){
        ++mQuantity;
        displayQuantity();
        resetTotalPrice();
    }

    public void decrement(View view) {
        if (mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetTotalPrice();
        }

    }
    private void  resetTotalPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }
}

