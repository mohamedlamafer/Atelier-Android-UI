package com.example.applicationdecontact



import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {

    private lateinit var etFullName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAddress1: EditText
    private lateinit var etAddress2: EditText
    private lateinit var rgCategory: RadioGroup
    private lateinit var btnAdd: Button
    private lateinit var btnReset: Button
    private lateinit var tvContactDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liaison avec les éléments
        etFullName = findViewById(R.id.etFullName)
        etPhone = findViewById(R.id.etPhone)
        etEmail = findViewById(R.id.etEmail)
        etAddress1 = findViewById(R.id.etAddress1)
        etAddress2 = findViewById(R.id.etAddress2)
        rgCategory = findViewById(R.id.rgCategory)
        btnAdd = findViewById(R.id.btnAdd)
        btnReset = findViewById(R.id.btnReset)
        tvContactDisplay = findViewById(R.id.tvContactDisplay)

        // Bouton Ajouter
        btnAdd.setOnClickListener { ajouterContact() }

        // Bouton Réinitialiser
        btnReset.setOnClickListener { reinitialiser() }
    }

    private fun ajouterContact() {
        val nom = etFullName.text.toString().trim()
        val telephone = etPhone.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val adresse1 = etAddress1.text.toString().trim()
        val adresse2 = etAddress2.text.toString().trim()

        // Vérification des champs
        if (nom.isEmpty()) { toast("Le nom est obligatoire"); return }
        if (telephone.isEmpty()) { toast("Le téléphone est obligatoire"); return }
        if (email.isEmpty()) { toast("L'email est obligatoire"); return }
        if (adresse1.isEmpty()) { toast("L'adresse ligne 1 est obligatoire"); return }

        val selectedId = rgCategory.checkedRadioButtonId
        if (selectedId == -1) { toast("Veuillez choisir une catégorie"); return }

        val radioButton = findViewById<RadioButton>(selectedId)
        val category = radioButton.text.toString()

        // Affichage du contact
        val contactInfo = """
            Nom: $nom
            Téléphone: $telephone
            Email: $email
            Adresse: $adresse1, $adresse2
            Catégorie: $category
        """.trimIndent()

        tvContactDisplay.text = contactInfo
        Toast.makeText(this, "Contact ajouté", Toast.LENGTH_SHORT).show()
    }

    private fun reinitialiser() {
        etFullName.setText("")
        etPhone.setText("")
        etEmail.setText("")
        etAddress1.setText("")
        etAddress2.setText("")
        rgCategory.clearCheck()
        tvContactDisplay.text = "Aucun contact ajouté"
        Toast.makeText(this, "Formulaire réinitialisé", Toast.LENGTH_SHORT).show()
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
