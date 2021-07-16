package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RemoveActivity extends AppCompatActivity {

    EditText etFood;

    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        etFood = findViewById(R.id.etRemoveFood);

        dbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRemoveFood:
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String whereClause = "food=?";
                String[] whereArgs = new String[] {etFood.getText().toString()};

                db.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);

                dbHelper.close();
                break;
            case R.id.btnRemoveCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
