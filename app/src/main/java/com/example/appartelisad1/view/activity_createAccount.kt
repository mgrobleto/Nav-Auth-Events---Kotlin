package com.example.appartelisad1.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appartelisad1.databinding.ActivityCreateAccountBinding
import com.example.appartelisad1.model.singUp
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.regex.Pattern.*

class activity_createAccount : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------
        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolCrearCuenta
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Crear Cuenta"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.btCrearCuenta.setOnClickListener {

            if(validateFields(binding.inputEmail, binding.inputUsername, binding.inputPassword, binding.inputConfirPassword) && validatePasswords(binding.idPassword.text.toString().trim(), binding.idConfirmPassword.text.toString().trim())
                && validatePassSize(binding.idPassword.text.toString().trim()) && validateEmail(binding.idEmail.text.toString().trim()) && validateUsername(binding.idUsername.text.toString().trim())){

                    //singUp(binding.idEmail.text.toString().trim(), binding.idUsername.text.toString().trim(), binding.idPassword.text.toString().trim());
                Toast.makeText(this, "El usuario ha sido creado", Toast.LENGTH_SHORT).show();
                finish()
            }

        }

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

    // validar si las contrasenas son iguales
    private fun validatePasswords(pass1:String, pass2:String) :Boolean{
        var isValid = true

        if (!pass2.equals(pass1)){
            Snackbar.make(binding.root, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }


    /*private fun validatePassDigits(pass1:String) : Boolean{
        // validar que la tenga digitos y letras
         var isValid = false

        var hasnum = false;
        var hasUpper = false;
        var hasSpecialSymbol = false;

        //number
        if(pass1.matches(Regex("(.*[0-9].*)")))
        {
            hasnum = true;
        }else{
            hasUpper = false;
        }
        //upper case
        if(pass1.matches(Regex("(.*[A-Z].*)")))
        {
            hasUpper = true;
        }else{
            hasUpper = false;
        }
        //symbol
        if(pass1.matches(Regex("^(?=.*[_.()$&@]).*$"))){
            hasSpecialSymbol = true;
        }else{
            hasSpecialSymbol = false;
        }

        if(hasSpecialSymbol && hasUpper && hasnum){
            isValid = false
            Snackbar.make(binding.root, "La contraseña debe contener digitos y letras", Snackbar.LENGTH_SHORT).show()
        }else{
            isValid = true
        }

        return isValid
    }*/

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

    private fun validateEmail(email:String) :Boolean {
        var isValid = false

        if(email.length >0 && email.length <= 30){
            isValid = true
        }
        else{
            Snackbar.make(binding.root, "Email no valido", Snackbar.LENGTH_SHORT).show()
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


