# Application de Gestion d’un Cambiste à Lubumbashi

📌 **Secteur** : Finance / Change de devises  
💡 **Idée** : Une application mobile pour aider les cambistes à gérer leurs transactions de change.

---

## Fonctionnalités

✅ **Gestion des Taux de Change** :
- Ajouter et mettre à jour les taux de change (USD/CDF, EUR/CDF, ZAR/CDF…).
- Afficher l’historique des taux de change.

✅ **Transactions** :
- Enregistrer une transaction (achat/vente de devise, montant, client).
- Calculer automatiquement les conversions lors d’une transaction.
- Génération automatique du total en fonction du taux appliqué.

✅ **Suivi des Opérations** :
- Afficher le solde actuel en devises disponibles (USD, CDF…).
- Suivi des entrées et sorties d’argent.

✅ **Rapports** :
- Génération de rapports sur les bénéfices quotidiens/mensuels.

✅ **Interface Utilisateur** :
- Liste des transactions avec option de tri et recherche par client ou date.

---

## Technologies Utilisées

- **Langage** : Kotlin
- **Base de Données** : Room Database
- **Architecture** : MVVM (Model-View-ViewModel)
- **Autres** : Retrofit (pour les taux de change en temps réel), Material Design

---

## Installation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/rooneyi/Gestion-Cambiste