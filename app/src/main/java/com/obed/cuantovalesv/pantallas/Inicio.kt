package com.obed.cuantovalesv.pantallas

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.Chip
import com.obed.cuantovalesv.R
import com.obed.cuantovalesv.databinding.ActivityInicioBinding
import com.obed.cuantovalesv.databinding.BottomSheetFiltrosBinding

class Inicio : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding
    private val sitiosSeleccionados = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInicioBinding.inflate(layoutInflater)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.appBar) { view, insets ->
            val statusBar = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            view.updatePadding(top = statusBar.top)
            insets
        }


        asignarEventos()
    }


    private fun asignarEventos(){
//        ----- Asignar bottomSheet para filtros -----
        binding.btnFiltros.setOnClickListener {
            val bottomSheet = BottomSheetDialog(this)

            // ya que usamos binding aqui le asignamos el XML completo a la variable
            val filtrosBinding = BottomSheetFiltrosBinding.inflate(
                layoutInflater
            )

            bottomSheet.setContentView(filtrosBinding.root)
            bottomSheet.show()

            // y aqui accedemos al groupChip por medio del ID y detectamos el evento
            filtrosBinding.grupoFiltros.setOnCheckedStateChangeListener { group, chipId ->
                sitiosSeleccionados.clear()

                for (i in 0 until group.childCount){
                    val chip = group.getChildAt(i) as Chip

                    if(chip.isChecked){
                        sitiosSeleccionados.add(chip.text.toString())
                        chip.setChipBackgroundColorResource(R.color.black)
                        chip.setTextColor(
                            ContextCompat.getColor(this, R.color.secondary)
                        )
                    }else{
                        chip.setChipBackgroundColorResource(R.color.secondary)
                        chip.setTextColor(
                            ContextCompat.getColor(this, R.color.black)
                        )
                    }

                }
                Log.d("SITIOS SELECCIONADOS", sitiosSeleccionados.toString())
            }
        }

//        ----- Asignar valores a seleccion de cantidades -----
        val opcionesCantidad = arrayOf(
            "Cantidad de productos por sitio",
            "2",
            "3",
            "4",
            "5"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            opcionesCantidad
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.selectCantidad.adapter = adapter
        (binding.selectCantidad.selectedView as? TextView)?.setTextColor(
            ContextCompat.getColor(this,R.color.black)
        )
    }


}