import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MatchCards {
    class Card {
        String cardName;
        ImageIcon cardImageIcon;

        Card(String cardName, ImageIcon cardImageIcon) {
            this.cardName = cardName;
            this.cardImageIcon = cardImageIcon;
        }

        public String toString() {
            return cardName;
        }
    }

    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    String[] cardList = {
        "darkness", "double", "fairy", "fighting", "fire",
        "grass", "lightning", "metal", "psychic", "water"
    };

    int rows = 4;
    int columns = 5;
    int cardWidth = 90;
    int cardHeight = 128;

    ArrayList<Card> cardSet;
    ImageIcon cardBackImageIcon;

    int boardWidth = columns * cardWidth;
    int boardHeight = rows * cardHeight;

    JFrame frame = new JFrame("Pokemon Match Cards");
    JPanel lobbyPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel controlPanel = new JPanel();
    JButton newGameButton = new JButton("New Game");
    JButton restartButton = new JButton("Restart Game");
    JButton leaderboardButton = new JButton("Show Leaderboard");

    int errorCount = 0;
    ArrayList<JButton> board;
    Timer hideCardTimer;
    boolean gameReady = false;
    JButton card1Selected;
    JButton card2Selected;
    ArrayList<Player> leaderboard = new ArrayList<>();
    Player currentPlayer;
    int streak = 0;

    MatchCards() {
        setupFrame();
    }

    void setupFrame() {
        frame.setLayout(new CardLayout());
        frame.setSize(boardWidth, boardHeight + 100);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupLobbyPanel();
        setupGamePanel();

        frame.add(lobbyPanel, "Lobby");
        frame.add(gamePanel, "Game");

        frame.setVisible(true);
    }

    void setupLobbyPanel() {
        lobbyPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Pokemon Match Cards!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        lobbyPanel.add(welcomeLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.addActionListener(e -> startNewGame());
        lobbyPanel.add(startButton, BorderLayout.SOUTH);
    }

    void setupGamePanel() {
        gamePanel.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Player: - | Score: 0");

        textPanel.setPreferredSize(new Dimension(boardWidth, 30));
        textPanel.add(textLabel);
        gamePanel.add(textPanel, BorderLayout.NORTH);

        board = new ArrayList<>();
        boardPanel.setLayout(new GridLayout(rows, columns));
        gamePanel.add(boardPanel, BorderLayout.CENTER);

        controlPanel.setLayout(new FlowLayout());

        restartButton.setFont(new Font("Arial", Font.PLAIN, 16));
        restartButton.setEnabled(false);
        restartButton.addActionListener(e -> restartGame());
        controlPanel.add(restartButton);

        leaderboardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        leaderboardButton.addActionListener(e -> showLeaderboard());
        controlPanel.add(leaderboardButton);

        gamePanel.add(controlPanel, BorderLayout.SOUTH);
    }

    void startNewGame() {
        String playerName = JOptionPane.showInputDialog(frame, "Enter your name:", "New Game", JOptionPane.PLAIN_MESSAGE);
        if (playerName == null || playerName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        currentPlayer = new Player(playerName, 0);
        textLabel.setText("Player: " + currentPlayer.name + " | Score: " + currentPlayer.score);
        setupCards();
        shuffleCards();
        initializeBoard();
        gameReady = true;
        restartButton.setEnabled(true);

        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "Game");
    }

    void restartGame() {
        String playerName = JOptionPane.showInputDialog(frame, "Enter your name:", "New Game", JOptionPane.PLAIN_MESSAGE);
        if (playerName == null || playerName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        currentPlayer = new Player(playerName, 0);
        setupCards();
        shuffleCards();
        initializeBoard();
        streak = 0;
        currentPlayer.score = 0;
        textLabel.setText("Player: " + currentPlayer.name + " | Score: " + currentPlayer.score);
        gameReady = true;
    }

    void setupCards() {
        cardSet = new ArrayList<>();
        for (String cardName : cardList) {
            Image cardImg = new ImageIcon(getClass().getResource("./img/" + cardName + ".jpg")).getImage();
            ImageIcon cardImageIcon = new ImageIcon(cardImg.getScaledInstance(cardWidth, cardHeight, java.awt.Image.SCALE_SMOOTH));
            cardSet.add(new Card(cardName, cardImageIcon));
        }
        cardSet.addAll(cardSet);

        Image cardBackImg = new ImageIcon(getClass().getResource("./img/back.jpg")).getImage();
        cardBackImageIcon = new ImageIcon(cardBackImg.getScaledInstance(cardWidth, cardHeight, java.awt.Image.SCALE_SMOOTH));
    }

    void shuffleCards() {
        for (int i = 0; i < cardSet.size(); i++) {
            int j = (int) (Math.random() * cardSet.size());
            Card temp = cardSet.get(i);
            cardSet.set(i, cardSet.get(j));
            cardSet.set(j, temp);
        }
    }

    void initializeBoard() {
        boardPanel.removeAll();
        board.clear();

        for (int i = 0; i < cardSet.size(); i++) {
            JButton tile = new JButton();
            tile.setPreferredSize(new Dimension(cardWidth, cardHeight));
            tile.setOpaque(true);
            tile.setIcon(cardBackImageIcon);
            tile.setFocusable(false);
            int index = i;
            tile.addActionListener(e -> handleCardSelection(tile, index));
            board.add(tile);
            boardPanel.add(tile);
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }

    void handleCardSelection(JButton tile, int index) {
        if (!gameReady || tile.getIcon() != cardBackImageIcon) return;

        tile.setIcon(cardSet.get(index).cardImageIcon);

        if (card1Selected == null) {
            card1Selected = tile;
        } else if (card2Selected == null) {
            card2Selected = tile;

            if (card1Selected.getIcon().equals(card2Selected.getIcon())) {
                streak++;
                int points = 10 + (streak - 1) * 5;
                currentPlayer.score += points;
                textLabel.setText("Player: " + currentPlayer.name + " | Score: " + currentPlayer.score);
                card1Selected = null;
                card2Selected = null;
            } else {
                streak = 0;
                currentPlayer.score -= 5;
                textLabel.setText("Player: " + currentPlayer.name + " | Score: " + currentPlayer.score);
                Timer t = new Timer(1000, e -> {
                    card1Selected.setIcon(cardBackImageIcon);
                    card2Selected.setIcon(cardBackImageIcon);
                    card1Selected = null;
                    card2Selected = null;
                });
                t.setRepeats(false);
                t.start();
            }
        }
    }

    void showLeaderboard() {
        leaderboard.add(new Player(currentPlayer.name, currentPlayer.score));
        selectionSort(leaderboard);

        StringBuilder leaderboardText = new StringBuilder("Leaderboard:\n");
        for (int i = 0; i < leaderboard.size(); i++) {
            Player p = leaderboard.get(i);
            leaderboardText.append((i + 1) + ". " + p.name + " - " + p.score + "\n");
        }

        JOptionPane.showMessageDialog(frame, leaderboardText.toString(), "Leaderboard", JOptionPane.PLAIN_MESSAGE);
    }

    void selectionSort(ArrayList<Player> players) {
        for (int i = 0; i < players.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).score > players.get(maxIdx).score) {
                    maxIdx = j;
                }
            }
            Player temp = players.get(maxIdx);
            players.set(maxIdx, players.get(i));
            players.set(i, temp);
        }
    }

    public static void main(String[] args) {
        new MatchCards();
    }
}
