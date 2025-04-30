import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var result: TextView
    private lateinit var addBtn: Button
    private lateinit var subBtn: Button
    private lateinit var mulBtn: Button
    private lateinit var divBtn: Button
    private lateinit var clearBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById(R.id.number1)
        num2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)
        addBtn = findViewById(R.id.add)
        subBtn = findViewById(R.id.subtract)
        mulBtn = findViewById(R.id.multiply)
        divBtn = findViewById(R.id.divide)
        clearBtn = findViewById(R.id.clear)

        addBtn.setOnClickListener { calculate("+") }
        subBtn.setOnClickListener { calculate("-") }
        mulBtn.setOnClickListener { calculate("*") }
        divBtn.setOnClickListener { calculate("/") }

        clearBtn.setOnClickListener {
            num1.text.clear()
            num2.text.clear()
            result.text = ""
        }
    }

    private fun calculate(op: String) {
        val n1Text = num1.text.toString()
        val n2Text = num2.text.toString()

        if (n1Text.isEmpty() || n2Text.isEmpty()) {
            Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val n1 = n1Text.toDouble()
        val n2 = n2Text.toDouble()

        val res = when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> {
                if (n2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                n1 / n2
            }
            else -> 0.0
        }

        result.text = "Result: $res"
    }
}
