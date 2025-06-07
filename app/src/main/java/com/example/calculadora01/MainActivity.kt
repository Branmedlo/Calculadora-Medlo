package com.example.calculadora01

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {


     //VARIABLES
     var num1: Float = 0.0f
     var num2: Float = 0.0f
     var operacionAsignada = "0"
     var capturaDePantalla = "0"
     lateinit var pantalla2: TextView
     lateinit var pantalla: TextView

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         pantalla = findViewById(R.id.textView)
         pantalla2 = findViewById(R.id.textView2)

        val btnCero = findViewById<Button>(R.id.cero)
        btnCero.setOnClickListener{
            agregarNumero("0")
            reducirTamañoDeTexto()
        }

        val btnUno = findViewById<Button>(R.id.btn_uno)
        btnUno.setOnClickListener{
            agregarNumero("1")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnDos = findViewById<Button>(R.id.dos)
        btnDos.setOnClickListener{
            agregarNumero("2")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnTres = findViewById<Button>(R.id.tres)
        btnTres.setOnClickListener{
            agregarNumero("3")
            limitarNumerosEnPantalla()
        }

        val btnCuatro = findViewById<Button>(R.id.cuatro)
        btnCuatro.setOnClickListener{
            agregarNumero("4")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnCinco = findViewById<Button>(R.id.cinco)
        btnCinco.setOnClickListener{
            agregarNumero("5")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnSeis = findViewById<Button>(R.id.seis)
        btnSeis.setOnClickListener{
            agregarNumero("6")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnSiete = findViewById<Button>(R.id.siete)
        btnSiete.setOnClickListener{
            agregarNumero("7")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnOcho = findViewById<Button>(R.id.ocho)
        btnOcho.setOnClickListener{
            agregarNumero("8")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }

        val btnNueve = findViewById<Button>(R.id.nueve)
        btnNueve.setOnClickListener{
            agregarNumero("9")
            limitarNumerosEnPantalla()
            reducirTamañoDeTexto()
        }


        val btnClear = findViewById<Button>(R.id.Ac)
        btnClear.setOnClickListener{
            pantalla2.text = "0"
            pantalla.text = ""
            aumentarTamañoDeTexto()
        }

        /* dropLast metodo que utilizo para lograr borrar de uno en uno*/

        val borradoParcial = findViewById<ImageButton>(R.id.masmenos)
        borradoParcial.setOnClickListener{
            pantalla2.text = pantalla2.text.toString().dropLast(1)  //Borra el ultimo digito al ultimo deja la pantalla vacia
            if (pantalla2.text.toString().isEmpty()){         //Aquí valido si la pantalla esta vacia y de estarlo lo vuelve a 0
                pantalla2.text = "0"
            }
            aumentarTamañoDeTexto()

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

         val btnMultiplicacion = findViewById<ImageButton>(R.id.multiplicacion)
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

         val btnPorcentaje = findViewById<ImageButton>(R.id.porcentage)
         btnPorcentaje.setOnClickListener{
             operacionesMatematicas("%")
         }

        val btnResultado = findViewById<ImageButton>(R.id.igual)
        btnResultado.setOnClickListener() {

            val segundaCapturaDePantalla = pantalla2.text.toString()

            try {
                num2 = segundaCapturaDePantalla.toFloat()
            } catch (e: NumberFormatException) {
                println("No se ha ingresado un numero valido")
            }
            var resultado = 0.0f

            when(operacionAsignada){
                "+" -> resultado = suma()
                "-" -> resultado = resta()
                "*" -> resultado = multiplicaion()
                "/" -> resultado = division()
                "%" -> resultado = porcentaje()
            }

            if (resultado % 1 == 0f) {
                pantalla.text = "= ${resultado.toInt()}"
            }else{
                pantalla.text = "= ${resultado}"

            }

            /*if (operacionAsignada == "+" && suma() % 1 == 0f) {
                pantalla.text = "= ${suma().toInt()}"
            }else if(operacionAsignada == "+"){
                pantalla.text = "= ${suma()}"
            }else if (operacionAsignada == "-" && resta() % 1 == 0f) {
                pantalla.text = "= ${resta().toInt()}"
            }else if(operacionAsignada == "-"){
                pantalla.text = "= ${resta()}"
            }else if (operacionAsignada == "*" && multiplicaion() % 1 == 0f) {
                pantalla.text = "= ${multiplicaion().toInt()}"
            }else if(operacionAsignada == "*"){
                pantalla.text = "= ${multiplicaion()}"
            }else if (operacionAsignada == "/" && division() % 1 == 0f) {
                pantalla.text = "= ${division().toInt()}"
            }else if(operacionAsignada == "/"){
                pantalla.text = "= ${division()}"
            }*/

        }
    }

    //Metodos

    fun suma():Float {
        var resultadoSuma = num1 + num2

        return resultadoSuma
    }

    fun resta(): Float{
        var resultadoResta = num1 - num2
        return resultadoResta
    }

    fun division(): Float{
        var resultadoDivision = num1 / num2
        return resultadoDivision
    }

    fun multiplicaion(): Float{
        var resultadoMultiplicacion = num1 * num2
        return resultadoMultiplicacion
    }

    fun porcentaje(): Float{
        val resultadoPorcentaje = (num1 / 100 * num2)
        return resultadoPorcentaje
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
            num1 = capturaDePantalla.toFloat()
        }catch (e:NumberFormatException){
            println("No se ha ingresado un numero valido")
        }

        pantalla2.text = "0"
    }

    fun limitarNumerosEnPantalla() {
        if (pantalla2.text.toString().length > 11) {
            pantalla2.text = pantalla2.text.toString().substring(0, 11)
            Toast.makeText(this, "Limite de digitos para ingresar", Toast.LENGTH_SHORT).show()
        }

        /* El metodo substring toma el primer indice de la cadena que le inidique y opcinalmente el ultimo y
        retorna el total de la cadena original. En este caso util para limitar el numero de diditos que el usuario puede
        ingresar
         */
    }

    fun reducirTamañoDeTexto(){
        if (pantalla2.text.toString().length == 6){
            pantalla2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50f)
        }
    }

    fun aumentarTamañoDeTexto(){
        if (pantalla2.text.toString().length < 6){
            pantalla2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 70f)
        }
    }

 }










