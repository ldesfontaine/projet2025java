## 🧾 **Rapport Fonctionnel – Système Arena**

### 🎯 Objectif du système

Le projet *Arena* est un jeu de combat entre personnages (joueurs et ennemis) où chaque entité possède des statistiques, des compétences (abilities) et une logique de progression. Il repose sur une architecture orientée objet claire, favorisant **la modularité, la réutilisabilité** et **l’extensibilité**.

---

## 🧩 **Fonctionnalités principales**

### 1. 👥 **Modélisation des personnages**

#### 🧬 Classe `Character` (abstraite)

* Représente un être pouvant combattre : joueur ou ennemi.
* Contient :

  * Statistiques (force, agilité, intelligence, santé)
  * Liste de compétences (`List<Ability>`)
  * Méthodes d’interaction : `takeDamage`, `executeAbility`, `isAlive`, etc.
* C’est une **superclasse** (parent commun).

#### 👤 `Player` hérite de `Character`

* Ajoute :

  * Notion de `Race` et `Profession`
  * Niveaux (`level`) et montée en puissance (`levelUp`)
* Spécificité : Le joueur choisit activement ses compétences.

#### 🧟 `Enemy` hérite aussi de `Character`

* Associé à une `Difficulty` (niveau d’adversité)
* Sélection automatique des compétences selon difficulté.

### 2. 🧠 **Capacités (`Ability`)**

#### 🔗 Interface `Ability`

* Définit l'API commune : `getName`, `applyEffect`, `execute`.
* Permet d'implémenter des compétences variées, interchangeables.

#### 🧨 Classe abstraite `SimpleDamageAbility` (hérite de `Ability`)

* Fournit une logique partielle pour les compétences infligeant des dégâts.
* Comporte :

  * Méthode d’effet par défaut (`applyEffect`)
  * Méthode protégée `computeBaseDamage` à personnaliser.

#### 🔥 Implémentations concrètes :

* `Backstab`, `Fireball`, `Slash`, `PiercingArrow`… Chaque classe redéfinit ses effets et dégâts spécifiques.

### 3. 🧝 **Races et Professions**

#### 🧬 Enum `Race`

* Donne les statistiques de base (ex. : force, agilité…) + compétences raciales (`PiercingArrow`).
* Exemples : `HUMAN`, `ELF`, `ORC`.

#### 🧑‍🏭 Enum `Profession`

* Fournit les **bonus de classe** (ex : +intelligence pour un `MAGE`) et les compétences associées (`Fireball`, `Slash`, etc.).

### 4. ⚔️ **Moteur de Combat**

#### `CombatEngine`

* Lance un combat (`fight`) entre un `Player` et un `Enemy`.
* Gestion des tours via `TurnManager`.

#### `TurnManager`

* File d'attente des participants
* Gère le passage au joueur suivant

### 5. 🖥️ **Interface Graphique**

#### `SwingCombatUI`

* Interface Swing avec :

  * Gestion de l’état du jeu
  * Affichage du joueur, des ennemis
  * Interaction utilisateur

---

## 🧬 Zoom sur l’héritage – Utilisation et intérêt

### 🏛️ Objectif de l’héritage

L’héritage permet de **partager du code commun** entre plusieurs classes, d’en **spécialiser certaines** tout en garantissant **une structure cohérente**.

---

### 🧱 **Hiérarchie des classes via héritage**

#### `Character` ← `Player`, `Enemy`

* **But** : factoriser la logique de base (santé, stats, gestion des compétences)
* **Spécialisation** :

  * `Player` → ajout de niveau, race, profession, choix de compétence manuel
  * `Enemy` → difficulté, IA, sélection automatique

#### `Ability` (interface) → `SimpleDamageAbility` (abstract) → `Fireball`, `Backstab`, etc.

* **But** : décrire une API commune, tout en permettant une implémentation partielle.
* `SimpleDamageAbility` simplifie la création d’attaques en fournissant un squelette.
* Chaque attaque peut ensuite spécialiser ses dégâts.

---

### 🔁 **Polymorphisme**

Grâce à l’héritage :

* Un `List<Ability>` peut contenir **n’importe quelle compétence**, qu’elle soit `Fireball`, `Slash`, etc.
* Un `Character` peut être traité uniformément (joueur ou ennemi) dans la boucle de combat.

---

## ✅ Avantages du design

| Caractéristique  | Description                                                                                          |
| ---------------- | ---------------------------------------------------------------------------------------------------- |
| **Extensible**   | Ajouter une nouvelle race, compétence, ou type d’ennemi est facile sans modifier le cœur du système. |
| **Modulaire**    | Les responsabilités sont bien séparées (`UI`, `combat`, `stats`, `abilities`).                       |
| **Réutilisable** | Les classes abstraites et interfaces permettent de réutiliser des comportements sans duplication.    |
| **Lisible**      | Le système d’héritage clarifie la hiérarchie des entités du jeu.                                     |

---
