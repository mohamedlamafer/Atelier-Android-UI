# 🧮 Application Calculatrice

## 👤 Étudiant
- **Nom :** Mohamed Lamafer  
- **Date :** 07/11/2025  

---

## 📱 Description
Cette application Android est une **calculatrice complète** développée avec **Kotlin**.  
Elle permet d'effectuer les opérations suivantes :
- ➕ Addition  
- ➖ Soustraction  
- ✖️ Multiplication  
- ➗ Division  

Chaque opération est enregistrée dans un **historique** visible directement dans l'application.

---

## ⚙️ Fonctionnalités
- ✅ Interface réalisée avec **LinearLayout**
- ✅ Gestion complète des boutons en **Kotlin**
- ✅ Validation des entrées (empêche les champs vides)
- ✅ Gestion d’erreur pour la division par zéro
- ✅ Affichage dynamique du **résultat** et de l’**historique**
- ✅ Design clair et lisible

---

## 🧠 Exemple d'utilisation
1. Entrer deux nombres  
2. Appuyer sur le bouton de l’opération voulue  
3. Le résultat s’affiche immédiatement  
4. L’opération est ajoutée en haut de l’historique  

Exemple d’historique :  
5 + 3 = 8
8 × 2 = 16
16 ÷ 4 = 4

## 🖼 Captures d'écran
![Calculatrice](screenshots/calculatrice.png)

## 📚 Ce que j'ai appris
- Créer des interfaces Android avec **LinearLayout**  
- Utiliser des `EditText`, `TextView` et `Button`  
- Gérer les clics avec `setOnClickListener`  
- Utiliser la fonction `when` pour simplifier le code  
- Mettre à jour dynamiquement un historique d’opérations  


## 💡 Difficultés rencontrées
- **Centrage du contenu** → corrigé avec `android:gravity="center"`  
- **Division par zéro** → ajout d’un contrôle avant le calcul  
- **Affichage de l’historique** → résolu avec une `MutableList` et `joinToString()`  

