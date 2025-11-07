package com.example.activitytest2



    
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Déclaration des vues
    private lateinit var tvResult: TextView
    private lateinit var tvHistory: TextView
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button

    // Liste pour enregistrer l'historique
    private val historique = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liaison des vues
        tvResult = findViewById(R.id.tvResult)
        tvHistory = findViewById(R.id.tvHistory)
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)

        // Boutons et opérations
        btnAdd.setOnClickListener { calculer("addition") }
        btnSubtract.setOnClickListener { calculer("soustraction") }
        btnMultiply.setOnClickListener { calculer("multiplication") }
        btnDivide.setOnClickListener { calculer("division") }
    }

    private fun calculer(operation: String) {
        val nombre1Text = etNumber1.text.toString()
        val nombre2Text = etNumber2.text.toString()

        // Vérification des champs
        if (nombre1Text.isEmpty() || nombre2Text.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les deux nombres", Toast.LENGTH_SHORT).show()
            return
        }

        val nombre1 = nombre1Text.toDouble()
        val nombre2 = nombre2Text.toDouble()

        // Calcul selon l'opération
        val resultat = when (operation) {
            "addition" -> nombre1 + nombre2
            "soustraction" -> nombre1 - nombre2
            "multiplication" -> nombre1 * nombre2
            "division" -> {
                if (nombre2 == 0.0) {
                    Toast.makeText(this, "Division par zéro impossible", Toast.LENGTH_SHORT).show()
                    return
                }
                nombre1 / nombre2
            }
            else -> 0.0
        }

        // Affichage du résultat
        tvResult.text = "Résultat : $resultat"

        // Ajout à l'historique
        val symbole = when (operation) {
            "addition" -> "+"
            "soustraction" -> "-"
            "multiplication" -> "×"
            "division" -> "÷"
            else -> "?"
        }

        val operationTexte = "$nombre1 $symbole $nombre2 = $resultat"
        historique.add(0, operationTexte) // ajouter en haut
        afficherHistorique()
    }

    private fun afficherHistorique() {
        val texteHistorique = if (historique.isEmpty()) {
            "Aucune opération effectuée."
        } else {
            "Historique des opérations :\n" + historique.joinToString("\n")
        }
        tvHistory.text = texteHistorique
    }
}
