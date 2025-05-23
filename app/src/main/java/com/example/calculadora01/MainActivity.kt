package com.example.calculadora01

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
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
     lateinit var pantalla2: TextView
     lateinit var pantalla: TextView

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         pantalla = findViewById<TextView>(R.id.textView)
         pantalla2 = findViewById<TextView>(R.id.textView2)

        val btnCero = findViewById<Button>(R.id.cero)
        btnCero.setOnClickListener{
           agregarNumero("0")
        }

        val btnUno = findViewById<Button>(R.id.btn_uno)
        btnUno.setOnClickListener{
           agregarNumero("1")
              //Apend agrega un nuevo digito
        }

        val btnDos = findViewById<Button>(R.id.dos)
        btnDos.setOnClickListener{
           agregarNumero("2")
        }

        val btnTres = findViewById<Button>(R.id.tres)
        btnTres.setOnClickListener{
            agregarNumero("3")
        }

        val btnCuatro = findViewById<Button>(R.id.cuatro)
        btnCuatro.setOnClickListener{
           agregarNumero("4")
        }

        val btnCinco = findViewById<Button>(R.id.cinco)
        btnCinco.setOnClickListener{
           agregarNumero("5")
        }

        val btnSeis = findViewById<Button>(R.id.seis)
        btnSeis.setOnClickListener{
           agregarNumero("6")
        }

        val btnSiete = findViewById<Button>(R.id.siete)
        btnSiete.setOnClickListener{
           agregarNumero("7")
        }

        val btnOcho = findViewById<Button>(R.id.ocho)
        btnOcho.setOnClickListener{
            agregarNumero("8")
        }

        val btnNueve = findViewById<Button>(R.id.nueve)
        btnNueve.setOnClickListener{
            agregarNumero("9")
        }


        val btnClear = findViewById<Button>(R.id.Ac)
        btnClear.setOnClickListener{
            pantalla2.text = "0"
            pantalla.text = ""
        }

        /* dropLast metodo que utilizo para lograr borrar de uno en uno*/

        val borradoParcial = findViewById<ImageButton>(R.id.masmenos)
        borradoParcial.setOnClickListener{
            pantalla2.text = pantalla2.text.toString().dropLast(1)  //Borra el ultimo digito al ultimo deja la pantalla vacia
            if (pantalla2.text.toString().isEmpty()){         //Aquí valido si la pantalla esta vacia y de estarlo lo vuelve a 0
                pantalla2.text = "0"
            }

        }

        val btnSuma = findViewById<ImageButton>(R.id.suma)
        btnSuma.setOnClickListener{

             operacionesMatematicas("+")

        }
         val btnResta = findViewById<ImageButton>(R.id.resta)
         btnResta.setOnClickListener{

             operacionesMatematicas("-")
         }

         val btnDivision = findViewById<ImageButton>(R.id.division)
         btnDivision.setOnClickListener{

             operacionesMatematicas("/")
         }

         var btnMultiplicacion = findViewById<ImageButton>(R.id.multiplicacion)
         btnMultiplicacion.setOnClickListener{

             operacionesMatematicas("*")
         }

         val btnPunto = findViewById<ImageButton>(R.id.punto)
         btnPunto.setOnClickListener{
            if (pantalla2.text == "0"){
                pantalla2.text = "0."
            }
            else if (pantalla2.text.toString().contains(".")){
                pantalla2.text = pantalla2.text.toString()
            }else{
                pantalla2.append(".")
            }
         }

        val btnResultado = findViewById<ImageButton>(R.id.igual)
        btnResultado.setOnClickListener(){

            var segundaCapturaDePantalla = pantalla2.text.toString()

            try {
                num2 = segundaCapturaDePantalla.toInt()
            } catch (e: NumberFormatException){
                println("No se ha ingresado un numero valido")
            }

            when(operacionAsignada){
                "+" -> pantalla.text = "= ${suma()}"
                "-" -> pantalla.text = "= ${resta()}"
                "*" -> pantalla.text = "= ${multiplicaion()}"
                "/" -> pantalla.text = "= ${division()}"
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

    fun agregarNumero(numero:String){
        if (pantalla2.text.toString() == "0"){
            pantalla2.text = numero
        }
        else{
            pantalla2.append(numero)
        }
    }

    fun operacionesMatematicas(operacion: String){

        operacionAsignada = operacion
        capturaDePantalla = pantalla2.text.toString()

        try {
            num1 = capturaDePantalla.toInt()
        }catch (e:NumberFormatException){
            println("No se ha ingresado un numero valido")
        }

        pantalla2.text = "0"
    }

 }









