package com.mtw.alejandro.keyboardsamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//class MainActivity : AppCompatActivity() implements AdapterView.OnItemSelectedListener {
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    var mSpinnerLabel = ""
    private val TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (label_spinner != null) {

            label_spinner.setOnItemSelectedListener(this)
        }

        val adapter = ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        if (label_spinner != null)
        {
            label_spinner.setAdapter(adapter)
        }

    }

    fun showText(view: View){
       if (editText_main != null)
       {
           val showString: String = editText_main.text.toString () + " - " + mSpinnerLabel
           text_phonelabel.text = showString
       }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d(TAG, "onNothingSelected: ")
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       // mSpinnerLabel = adapterView?.getItemIdAtPosition(position).toString()
        mSpinnerLabel = label_spinner.selectedItem.toString()
        if (view != null) {
            showText(view)
        }
    }

    /*fun showText(v: View){
        if (editText_main != null)
        {
            var showString: String = editText_main.text.toString()
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()
        }
    }  */

}
