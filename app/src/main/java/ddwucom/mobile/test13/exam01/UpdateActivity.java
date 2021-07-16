package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText etId;
    EditText etFood;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etId = findViewById(R.id.etUpdateId);
        etFood = findViewById(R.id.etUpdateFood);

        dbHelper = new FoodDBHelper(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateFood:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues value = new ContentValues();
                value.put(FoodDBHelper.COL_FOOD, etFood.getText().toString());

                String whereClause = "_id=?";
                String[] whereArgs = new String[] {etId.getText().toString()};

                db.update(FoodDBHelper.TABLE_NAME, value, whereClause, whereArgs);

                dbHelper.close();
                break;
            case R.id.btnUpdateCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }


}
