package com.example.profilutilisateur


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var etNom: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liaison avec les vues
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        etNom = findViewById(R.id.etNom)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        btnSave = findViewById(R.id.btnSave)

        // Pré-remplir les champs avec les infos existantes
        etNom.setText(tvName.text.toString())
        etEmail.setText(tvEmail.text.toString())

        // Bouton "Enregistrer"
        btnSave.setOnClickListener {
            enregistrerProfil()
        }
    }

    private fun enregistrerProfil() {
        val nom = etNom.text.toString()
        val email = etEmail.text.toString()
        val telephone = etPhone.text.toString()

        // Vérifications simples
        if (nom.isEmpty()) {
            Toast.makeText(this, "Le nom est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "L'email est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }
        if (telephone.isEmpty()) {
            Toast.makeText(this, "Le téléphone est obligatoire", Toast.LENGTH_SHORT).show()
            return
        }

        // Mise à jour de l'affichage
        tvName.text = nom
        tvEmail.text = email

        // Message de succès
        Toast.makeText(this, "Profil enregistré avec succès !", Toast.LENGTH_LONG).show()
    }
}
