package tads.eaj.ufrn.colorblindtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.colorblindtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val setResposta1Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewResposta1.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,getString(R.string.Cancelado), Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewResposta2.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,getString(R.string.Cancelado), Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta3Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewResposta3.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,getString(R.string.Cancelado), Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonTeste1.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("imagem", R.drawable.teste1)
            intent.putExtras(bundle)
            setResposta1Launcher.launch(intent)
        }

        binding.buttonTeste2.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("imagem", R.drawable.teste2)
            intent.putExtras(bundle)

            setResposta2Launcher.launch(intent)
        }

        binding.buttonTeste3.setOnClickListener {
            val intent = Intent(this, RespostaActivity::class.java)

            val bundle = Bundle()
            bundle.putInt("imagem", R.drawable.teste3)
            intent.putExtras(bundle)

            setResposta3Launcher.launch(intent)
        }

        binding.buttonVerificar.setOnClickListener {
            if(binding.textViewResposta1.text == "" || binding.textViewResposta2.text == "" || binding.textViewResposta3.text == ""){
                Toast.makeText(this, getString(R.string.Aviso_Inicial), Toast.LENGTH_SHORT).show()
            }else if (binding.textViewResposta1.text == "29" && binding.textViewResposta2.text == "74" && binding.textViewResposta3.text == "2"){
                binding.textViewResultadoFinal.text = getString(R.string.teste_Aprovado)
            }else{
                binding.textViewResultadoFinal.text = getString(R.string.teste_Invalido)
            }
        }

    }
}