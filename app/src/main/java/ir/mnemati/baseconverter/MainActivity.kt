package ir.mnemati.baseconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define Widgets
        val edInput:EditText = findViewById(R.id.input)
        val rb2t10: RadioButton = findViewById(R.id.r2to10)
        val rb10t2: RadioButton = findViewById(R.id.r10to2)
        val btnConvert: Button = findViewById(R.id.convert)
        val txtOutput:TextView = findViewById(R.id.output)
        val reset:Button = findViewById(R.id.reset)


        fun convertBinaryToDecimal(num: Long): Int {
            var num = num
            var decimalNumber = 0
            var i = 0
            var remainder: Long

            while (num.toInt() != 0) {
                remainder = num % 10
                num /= 10
                decimalNumber += (remainder * 2.0.pow(i.toDouble())).toInt()
                ++i
            }
            return decimalNumber


        }

        fun convertFrom10to2(num:Int){
            var number:Int = num
            var reminder:Int
            var result = ""

            while (number !=0){
                reminder = number % 2
                result =   reminder.toString() + result
                number /= 2
            }

            txtOutput.text = result



        }

        btnConvert.setOnClickListener {

            if (edInput.text.isBlank()){
                // codes
                //Toast.makeText(this, "Please insert input", Toast.LENGTH_LONG).show()
               // MotionToast.createToast()
                //   MotionToast.createToast(this, )
                MotionToast.createToast(this, "test","Please fill all the details!",
                    MotionToastStyle.WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
            }
            else{
                //codes
                if (rb2t10.isChecked){
                    // Convert 2 to 10
                    val inputNumber: Long = edInput.text.toString().toLong()
                    val decimal = convertBinaryToDecimal(inputNumber)
                    txtOutput.text = decimal.toString()
                }
                else{
                    // Convert 10 to 2
                    val inputNumber: Int = edInput.text.toString().toInt()
                    convertFrom10to2(inputNumber)

                }

            }
            reset.setOnClickListener {
                edInput.text.clear()
                txtOutput.text = ""
                edInput.requestFocus()
            }
        }






    } // end of onCreate

} // end of class