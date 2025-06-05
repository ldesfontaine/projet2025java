## 1. Fonctionnement du Code
Le projet est un jeu de combat textuel où un joueur affronte des ennemis de difficulté croissante. Voici les principaux éléments :

### Modèles :
- **Character** : Classe de base pour les personnages avec des attributs comme les points de vie (PV), la force, l’agilité et l’intelligence.
- **Player** : Représente le joueur, avec une race (ex. humain, orc) et une profession (ex. guerrier, mage).
- **Enemy** : Représente les ennemis, avec une difficulté (facile, moyen, difficile).

### Habiletés :
Situées dans le paquetage `com.arena.ability`, elles définissent les actions possibles (attaques, sorts, etc.) que le joueur ou l’ennemi peut utiliser.

### Combat :
La classe `CombatEngine` gère la logique des affrontements. Elle exécute les tours où le joueur et l’ennemi s’attaquent jusqu’à ce qu’un des deux soit vaincu.

### Interface Utilisateur :
Une interface graphique (`SwingCombatUI`) permet de visualiser les combats et d’interagir avec le jeu.

## 2. Workflow du Projet
Le déroulement du jeu suit ces étapes :

### Initialisation :
- Le joueur choisit sa race et sa profession (via la console ou l’interface graphique).
- Les ennemis sont générés avec des statistiques basées sur leur difficulté.

### Combat :
- Le joueur affronte un ennemi à la fois.
- À chaque tour :
  - Le joueur choisit une habileté (ex. attaquer).
  - L’ennemi riposte avec une action (souvent aléatoire).
- Le combat se termine quand un des deux n’a plus de PV.

### Progression :
- Si le joueur gagne :
  - Il monte en niveau (amélioration des stats).
  - Ses PV sont restaurés.
  - Il passe à l’ennemi suivant.
- Si le joueur perd :
  - Le jeu s’arrête.

### Victoire Finale :
- Le joueur gagne s’il bat tous les ennemis.

## 3. Tests
Les tests unitaires dans `CombatEngineTest.java` vérifient le bon fonctionnement du combat :

- **Victoire facile** : Un guerrier humain bat un Goblin faible.
- **Défaite** : Un mage humain perd contre un Dragon puissant.
- **Victoire serrée** : Un guerrier orc bat un ennemi moyen.

Ces tests utilisent des assertions pour valider les résultats et des messages pour montrer qui gagne.

## 4. Améliorations Possibles
- Ajouter des tests pour la montée en niveau ou les effets spécifiques des habiletés.
- Utiliser un outil comme Mockito pour simuler des comportements complexes.
- Mesurer la couverture de code avec JaCoCo pour s’assurer que tout est testé.
