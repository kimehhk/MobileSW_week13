package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.etAddFood);
        etNation = findViewById(R.id.etAddNation);

        dbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddFood:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());
                value.put(FoodDBHelper.COL_NATION, etNation.getText().toString());

                db.insert(FoodDBHelper.TABLE_NAME, null, value);

                dbHelper.close();
                break;
            case R.id.btnAddCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }

}
