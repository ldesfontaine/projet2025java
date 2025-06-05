package com.arena.ui;

import com.arena.ability.Ability;
import com.arena.model.Enemy;
import com.arena.model.Player;
import com.arena.model.difficulty.Difficulty;
import com.arena.stats.Profession;
import com.arena.stats.Race;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Interface graphique pour le jeu de combat utilisant Swing.
 */
public class SwingCombatUI extends JFrame {
    private final Player player;
    private final List<Enemy> foes;
    // Composants
    private final JLabel lblPlayerInfo = new JLabel();
    private final JLabel lblEnemyInfo = new JLabel();
    private final JPanel pnlAbilities = new JPanel(new GridLayout(0, 1, 5, 5));
    private final JTextArea taLog = new JTextArea();
    private Enemy currentEnemy;
    private int foeIndex = 0;
    private boolean gameOver = false;

    /**
     * Construit l'interface graphique et initialise le joueur et les ennemis.
     */
    public SwingCombatUI() {
        // --- Choix de la race et de la profession ---
        Race[] races = Race.values();
        Profession[] profs = Profession.values();
        Race chosenRace = (Race) JOptionPane.showInputDialog(null, "Choisissez votre race :", "Setup du Joueur", JOptionPane.QUESTION_MESSAGE, null, races, races[0]);
        Profession chosenProf = (Profession) JOptionPane.showInputDialog(null, "Choisissez votre classe :", "Setup du Joueur", JOptionPane.QUESTION_MESSAGE, null, profs, profs[0]);

        // --- Création du joueur et des ennemis ---
        player = new Player("Héros", chosenRace, chosenProf);
        foes = List.of(new Enemy("Goblin", Difficulty.EASY), new Enemy("Orc", Difficulty.MEDIUM), new Enemy("Dragon", Difficulty.HARD));
        nextEnemy();

        // --- Configuration de la fenêtre ---
        setTitle("Arena Battle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // — Panneau gauche : infos joueur + infos ennemi —
        JPanel pnlLeft = new JPanel();
        pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.Y_AXIS));
        lblPlayerInfo.setFont(lblPlayerInfo.getFont().deriveFont(Font.BOLD, 14f));
        lblEnemyInfo.setFont(lblEnemyInfo.getFont().deriveFont(Font.BOLD, 14f));
        pnlLeft.add(lblPlayerInfo);
        pnlLeft.add(Box.createVerticalStrut(10));
        pnlLeft.add(lblEnemyInfo);
        add(pnlLeft, BorderLayout.WEST);

        // — Panneau droit : subdivisé en deux —
        JPanel pnlRight = new JPanel(new BorderLayout(5, 5));
        //   - Haut : choix des attaques
        JScrollPane scrollAbilities = new JScrollPane(pnlAbilities, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAbilities.setBorder(BorderFactory.createTitledBorder("Choix des attaques"));
        pnlRight.add(scrollAbilities, BorderLayout.NORTH);
        //   - Bas : logs
        taLog.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(taLog);
        scrollLog.setBorder(BorderFactory.createTitledBorder("Journal de combat"));
        pnlRight.add(scrollLog, BorderLayout.CENTER);

        add(pnlRight, BorderLayout.CENTER);

        // Taille & affichage
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Initial paint
        updateUIComponents();
    }

    /**
     * Point d'entrée pour lancer l'interface graphique.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(SwingCombatUI::new);
    }

    /**
     * Passe à l'ennemi suivant ou termine le jeu.
     */
    private void nextEnemy() {
        if (foeIndex >= foes.size()) {
            endGame("🏆 Vous avez vaincu tous les adversaires !");
            return;
        }
        currentEnemy = foes.get(foeIndex++);
        log("\n--> Nouveau combat : " + currentEnemy.getName());
    }

    /**
     * Incrémente le niveau du joueur, restaure ses PV et logue l'événement.
     */
    private void playerLevelUp() {
        player.levelUp();  // utilise la méthode levelUp() définie dans Player
        log("*** Vous montez au niveau " + player.getLevel() + " ! PV restaurés à " + player.getHealth() + " ***");
    }

    /**
     * Met à jour les labels en incluant le niveau.
     */
    private void updateUIComponents() {
        lblPlayerInfo.setText(String.format("<html><body>Vous (lvl %d – %s %s)<br/>HP : %d / %d</body></html>", player.getLevel(), player.getRace(), player.getProfession(), player.getHealth(), player.getMaxHealth()));
        lblEnemyInfo.setText(String.format("<html><body>%s (lvl %d)<br/>HP : %d / %d</body></html>", currentEnemy.getName(), currentEnemy.getLevel(), currentEnemy.getHealth(), currentEnemy.getMaxHealth()));

        // reste inchangé…
        pnlAbilities.removeAll();
        if (!gameOver) {
            for (Ability ability : player.getAbilities()) {
                JButton btn = new JButton(ability.getName());
                btn.addActionListener(this::onPlayerAttack);
                pnlAbilities.add(btn);
            }
        }
        pnlAbilities.revalidate();
        pnlAbilities.repaint();
    }

    /**
     * Gère l'action d'attaque du joueur via un bouton.
     *
     * @param evt L'événement déclenché par le bouton.
     */
    private void onPlayerAttack(ActionEvent evt) {
        if (gameOver) return;

        // 1) Joueur attaque
        String name = ((JButton) evt.getSource()).getText();
        Ability ability = player.getAbilities().stream().filter(a -> a.getName().equals(name)).findFirst().orElseThrow();
        ability.execute(player, currentEnemy);
        log(String.format("Vous utilisez %s → %d HP restants à %s", ability.getName(), currentEnemy.getHealth(), currentEnemy.getName()));

        // 2) Vérification mort ennemi
        if (!currentEnemy.isAlive()) {
            log(currentEnemy.getName() + " est vaincu !");
            // Level-up du joueur
            playerLevelUp();
            nextEnemy();
            updateUIComponents();
            return;
        }

        // 3) Ennemi riposte
        Ability ai = currentEnemy.getAbilities().get((int) (Math.random() * currentEnemy.getAbilities().size()));
        ai.execute(currentEnemy, player);
        log(String.format("%s utilise %s → vous avez %d HP", currentEnemy.getName(), ai.getName(), player.getHealth()));

        // 4) Vérification mort joueur
        if (!player.isAlive()) {
            endGame("💀 Game Over… Vous êtes vaincu");
        }

        updateUIComponents();
    }

    /**
     * Termine le jeu avec un message final.
     *
     * @param message Le message de fin (victoire ou défaite).
     */
    private void endGame(String message) {
        gameOver = true;
        log("\n=== " + message + " ===");
        // désactive tous les boutons
        for (Component c : pnlAbilities.getComponents()) {
            c.setEnabled(false);
        }
    }

    /**
     * Ajoute une ligne au journal de combat.
     *
     * @param line La ligne à ajouter.
     */
    private void log(String line) {
        taLog.append(line + "\n");
        taLog.setCaretPosition(taLog.getDocument().getLength());
    }
}
