package powernepo.opensource.mytrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        if(id == R.id.btn_calculate) handleCalculate()

    }

    private fun handleCalculate(){
        if(isValid()){
            try{
                val distance = edt_distance.text.toString().toFloat()
                val price = edt_price.text.toString().toFloat()
                val autonomy = edt_autonomy.text.toString().toFloat()

                val result = ((distance * price) / autonomy)
                textResult.setText("TOTAL : R$ $result")
            }catch (err: NumberFormatException){
                Toast.makeText(this," ERRO :impossible to calculate letters",Toast.LENGTH_LONG)
            }
        }else Toast.makeText(this," ERRO : inform values correct",Toast.LENGTH_LONG)

    }

    private fun isValid(): Boolean{
        return ((edt_distance.text.toString() != "") && edt_price.text.toString() != "" &&
                (edt_autonomy.text.toString() != "" || edt_autonomy.text.toString() != ""))
    }
}
