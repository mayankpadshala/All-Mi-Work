package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 * package com.example.android.justjava;
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice(0);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int price = calculatePrice();
        displayPrice(price);

        String priceMessage = createOderSummary(price);

        EditText name = (EditText) findViewById(R.id.editText);
        String enteredName = name.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.orderSummaryEmailSubject, enteredName));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.oder_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

//    /**
//     * This method displays the given text on the screen.
//     */
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.oder_summary_text_view);
//        priceTextView.setText(message);
//    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "You cannot oder more than 100 coffee";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
            display(quantity);
        }
        else {
            Toast.makeText(this, "You cannot have less than 1 cofee", Toast.LENGTH_SHORT).show();
        }
    }



    /**
     * Calculate the price of the cofee
     *
     * @return price
     */

    private int calculatePrice() {
        int basePrice = 5;

        if (whpChkd()) {
            basePrice = basePrice + 1;
        }
        if (chltChkd()) {
            basePrice = basePrice + 2;
        }

        int price = quantity * basePrice;
        return price;
    }


    private Boolean whpChkd() {
        boolean checked = ((CheckBox) (findViewById(R.id.checkbox_topping))).isChecked();
        return checked;
    }

    private Boolean chltChkd() {
        CheckBox choChecked = (CheckBox) findViewById(R.id.checkbox_topping_chocolate);
        boolean chocolateCheck = choChecked.isChecked();
        return chocolateCheck;
    }

    /** Create a string to display oder summary
     *
     * @param price total orice
     * @return text summary
     */

    private String createOderSummary(int price) {
        price = calculatePrice();

        EditText name = (EditText) findViewById(R.id.editText);
        String enteredName = name.getText().toString();

        String s = "Name :" + enteredName.toUpperCase() + "\n";
        s = s + "Add Whipped Cream? " + whpChkd() + "\n";
        s = s + "Add Chocolate? " + chltChkd() + "\n";
        //Log.i("MainActivity", "createOderSummary: " + checked);
        s = s + "Quantity: " + quantity + "\n";
        s = s + "Total: $" + price + "\n";
        s = s + "Thank you!";
        return s;
    }




}