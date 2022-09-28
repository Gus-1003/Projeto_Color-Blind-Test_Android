package tads.eaj.ufrn.colorblindtest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.colorblindtest.databinding.ActivityRespostaBinding

class RespostaActivity : AppCompatActivity() {

    lateinit var binding: ActivityRespostaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_resposta)

        binding.imageViewTeste.setImageResource(intent.extras!!.getInt("imagem"))

        binding.buttonENVIAR.setOnClickListener{

            val intent = Intent()
            val bundle = Bundle()

            bundle.putString("result", binding.editTextNumber.text.toString())
            intent.putExtras(bundle)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.buttonCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}