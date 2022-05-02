package com.example.appartelisad1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appartelisad1.R
import com.example.appartelisad1.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class activity_login : AppCompatActivity() {
    //
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnInicar.setOnClickListener {
            if(validateFields(binding.inputUsername, binding.inputPassword) && validatePassSize(binding.password.text.toString().trim())
                && validateUsername(binding.tvUserName.text.toString().trim())){
                val intent = Intent(this, activityMenu::class.java)
                startActivity(intent)
            }
        }
    }

    fun onClickArteLista(view: View) {
        val intent= Intent(this,activityMenu::class.java)
        startActivity(intent)

    }
    fun onClickCrearCuenta(view: View) {
        val intent=Intent(this,activity_createAccount::class.java)
        startActivity(intent)

    }

    // valida si los campos estan vacios
    private fun validateFields(vararg textFields: TextInputLayout) :Boolean{
        var isValid = true

        for (txtField in textFields) {
            if(txtField.editText?.text.toString().trim().isEmpty()){
                txtField.error = "Campo requerido"
                isValid = false
            }
        }

        return isValid
    }

    private fun validatePassSize(pass:String) : Boolean{
        // validar que sea mayor que 3 o menor o igual a 8

        var isValid = false

        if(pass.length >=3 && pass.length <=8){
            isValid = true
        }
        else{
            Snackbar.make(binding.root, "Contraseña fuera de rango", Snackbar.LENGTH_SHORT).show()
        }

        return isValid
    }

    private fun validateUsername(username:String) : Boolean{
        var isValid = false

        if(username.length > 0 && username.length <= 15){
            isValid=true
        }else{
            Snackbar.make(binding.root, "Error al ingresar el nombre de usuario", Snackbar.LENGTH_SHORT).show()
        }
        return isValid
    }

}