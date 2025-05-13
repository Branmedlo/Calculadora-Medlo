package com.example.calculadora01

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Logger


class MainActivity : AppCompatActivity() {


     //VARIABLES
     var num1 = 0
     var num2 = 0
     var operacionAsignada = "0"
     var capturaDePantalla = "0"
    var prueba = "0"

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pantalla = findViewById<TextView>(R.id.textView)

        val btnCero = findViewById<Button>(R.id.cero)
        btnCero.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "0"
            }
            else {
                pantalla.append("0")
            }
        }

        val btnUno = findViewById<Button>(R.id.btn_uno)
        btnUno.setOnClickListener{
            if(pantalla.text.toString() == "0"){
                pantalla.text = "1"
            }
            else {
                pantalla.append("1")  //Apend agrega un nuevo digito
            }
        }

        val btnDos = findViewById<Button>(R.id.dos)
        btnDos.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "2"
            }
            else{
                pantalla.append("2")
            }
        }

        val btnTres = findViewById<Button>(R.id.tres)
        btnTres.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "3"
            }
            else{
                pantalla.append("3")
            }
        }

        val btnCuatro = findViewById<Button>(R.id.cuatro)
        btnCuatro.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "4"
            }
            else{
                pantalla.append("4")
            }
        }

        val btnCinco = findViewById<Button>(R.id.cinco)
        btnCinco.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "5"
            }
            else{
                pantalla.append("5")
            }
        }

        val btnSeis = findViewById<Button>(R.id.seis)
        btnSeis.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "6"
            }
            else{
                pantalla.append("6")
            }
        }

        val btnSiete = findViewById<Button>(R.id.siete)
        btnSiete.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "7"
            }
            else{
                pantalla.append("7")
            }
        }

        val btnOcho = findViewById<Button>(R.id.ocho)
        btnOcho.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "8"
            }
            else{
                pantalla.append("8")
            }
        }

        val btnNueve = findViewById<Button>(R.id.nueve)
        btnNueve.setOnClickListener{
            if (pantalla.text.toString() == "0"){
                pantalla.text = "9"
            }
            else{
                pantalla.append("9")
            }
        }


        val btnClear = findViewById<Button>(R.id.Ac)
        btnClear.setOnClickListener{
            pantalla.text = "0"
        }

        /* dropLast metodo que utilizo para lograr borrar de uno en uno*/

        val borradoParcial = findViewById<Button>(R.id.masmenos)
        borradoParcial.setOnClickListener{

            if  (pantalla.text.toString().isEmpty()){
                pantalla.text = "0"
            }
            else{
                pantalla.text = pantalla.text.toString().dropLast(1)
            }
        }

        val btnSuma = findViewById<Button>(R.id.suma)
        btnSuma.setOnClickListener{

            operacionAsignada = "*"  // Esto funciona porque al darle click la variable es asignada a este valor y sirve para poder hacer despues la validacion.

            capturaDePantalla = pantalla.text.toString()
             try {
                 num1 = capturaDePantalla.toInt()
             } catch (e:NumberFormatException){
                 println("No se ha ingresado un numero valido")
             }
            pantalla.text = "0"

        }
         val btnResta = findViewById<Button>(R.id.resta)
         btnResta.setOnClickListener{

             operacionAsignada = "-"

             capturaDePantalla = pantalla.text.toString()

             try {
                 num1 = capturaDePantalla.toInt()
             }catch (e:NumberFormatException){
                 println("No se ha ingresado un numero valido")
             }

             pantalla.text = "0"
         }

         val btnDivision = findViewById<Button>(R.id.division)
         btnDivision.setOnClickListener{

             operacionAsignada = "/"

             capturaDePantalla = pantalla.text.toString()

             try {
                 num1 = capturaDePantalla.toInt()
             }catch (e:NumberFormatException){
                 println("No se ha ingresado un numero valido")
             }

             pantalla.text = "0"
         }

         var btnMultiplicacion = findViewById<Button>(R.id.multiplicacion)
         btnMultiplicacion.setOnClickListener{

             operacionAsignada = "*"

             capturaDePantalla = pantalla.text.toString()


             try {
                 num1 = capturaDePantalla.toInt()
             }catch (e:NumberFormatException){
                 println("No se ha ingresado un numero valido")
             }

             pantalla.text = "0"
         }

        val btnResultado = findViewById<Button>(R.id.igual)
        btnResultado.setOnClickListener(){
            var segundaCapturaDePantalla = pantalla.text.toString()

            try {
                num2 = segundaCapturaDePantalla.toInt()
            } catch (e: NumberFormatException){
                println("No se ha ingresado un numero valido")
            }

            if (operacionAsignada == "+"){
                pantalla.text = suma().toString()
            }else if (operacionAsignada == "-"){
                pantalla.text = resta().toString()
            }else if (operacionAsignada == "/"){
                pantalla.text = division().toString()
            }else if (operacionAsignada == "*"){
                pantalla.text = multiplicaion().toString()
            }else{
                println("Operacion no encontrada")
            }


        }


    }

    //Metodos

    fun suma():Int {
        var resultadoSuma = num1 + num2
        return resultadoSuma
    }

    fun resta(): Int{
        var resultadoResta = num1 - num2
        return resultadoResta
    }

    fun division(): Int{
        var resultadoDivision = num1 / num2
        return resultadoDivision
    }

    fun multiplicaion(): Int{
        var resultadoMultiplicacion = num1 * num2
        return resultadoMultiplicacion
    }


 }







