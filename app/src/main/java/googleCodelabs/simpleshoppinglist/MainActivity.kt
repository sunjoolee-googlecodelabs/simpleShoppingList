package googleCodelabs.simpleshoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

private val TAG : String = "MainActivity"

//public
val ITEM_NAME_REQUEST : Int = 1

class MainActivity : AppCompatActivity() {

    lateinit var textViewList : MutableList<TextView>
    var textViewIdx : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewList = mutableListOf()
        initTextViewList()

        if(savedInstanceState != null){
            textViewIdx = savedInstanceState.getInt("textViewIdx")
            var shoppingItemList = savedInstanceState.getStringArray("shoppingItemList")

            for((i, item) in shoppingItemList!!.withIndex()){
                textViewList[i].text = item
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(textViewIdx != 0){
            outState.putInt("textViewIdx", textViewIdx)
            var shoppingItemList : Array<String> = arrayOf()
            for(i in 0 .. textViewIdx){
                shoppingItemList = shoppingItemList.plus(textViewList[i].text.toString())
            }
            outState.putStringArray("shoppingItemList", shoppingItemList)
        }
    }

    private fun initTextViewList(){
        var textView : TextView = findViewById(R.id.textView1)
        textViewList.add(textView)
        textView = findViewById(R.id.textView2)
        textViewList.add(textView)
        textView = findViewById(R.id.textView3)
        textViewList.add(textView)
        textView = findViewById(R.id.textView4)
        textViewList.add(textView)
        textView = findViewById(R.id.textView5)
        textViewList.add(textView)
        textView = findViewById(R.id.textView6)
        textViewList.add(textView)
        textView = findViewById(R.id.textView7)
        textViewList.add(textView)
        textView = findViewById(R.id.textView8)
        textViewList.add(textView)
        textView = findViewById(R.id.textView9)
        textViewList.add(textView)
        textView = findViewById(R.id.textView10)
        textViewList.add(textView)
    }

    fun launchAddItemActivity(view: View) {
        val intent = Intent(this, AddItemActivity::class.java)
        startActivityForResult(intent, ITEM_NAME_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ITEM_NAME_REQUEST){
            if(resultCode == RESULT_OK){
                val itemName = data?.getStringExtra(EXTRA_ITEM_NAME)
                Log.d(TAG, "itemName: $itemName received")

                textViewList[textViewIdx].text = itemName
                textViewIdx++
            }
        }
    }
}