package googleCodelabs.simpleshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

private val TAG : String = "AddItemActivity"

//public
val EXTRA_ITEM_NAME : String = "googleCodelabs.simpleshoppinglist.extra.ITEM_NAME"

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
    }

    fun itemCLicked(view: View) {
        val button : Button = view as Button
        val itemName : String = button.text.toString()

        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_ITEM_NAME, itemName)
        Log.d(TAG, "itemName: $itemName sent")

        setResult(RESULT_OK, replyIntent)
        finish()
    }

}