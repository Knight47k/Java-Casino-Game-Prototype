import java.io.*;
import java.util.*;
import java.security.SecureRandom;

class Casino {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    // --- YOUR ORIGINAL LOGIC (Save/Load/Encrypt) ---
    public static String numberToLetters(long number) {
        if (number <= 0) return "A";
        StringBuilder columnName = new StringBuilder();
        while (number > 0) {
            long modulo = (number - 1) % 26;
            columnName.append((char) ('A' + modulo));
            number = (number - 1) / 26;
        }
        return columnName.reverse().toString();
    }

    public static long lettersToNumber(String letters) {
        if (letters == null || !letters.matches("[A-Z]+")) return -1;
        long result = 0;
        for (int i = 0; i < letters.length(); i++) {
            result *= 26;
            result += (letters.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static String generateRandomKey(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder keyBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            keyBuilder.append(randomChar);
        }
        return keyBuilder.toString();
    }

    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                boolean isLowerCase = Character.isLowerCase(c);
                int base = isLowerCase ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char encryptedChar = (char) ((c - base + shift) % 26 + base);
                result.append(encryptedChar);
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                boolean isLowerCase = Character.isLowerCase(c);
                int base = isLowerCase ? 'a' : 'A';
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                char decryptedChar = (char) ((c - base - shift + 26) % 26 + base);
                result.append(decryptedChar);
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String textToBinary(String text) {
        StringBuilder binaryResult = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String binaryChar = Integer.toBinaryString(c);
            String padded = String.format("%8s", binaryChar).replace(' ', '0');
            binaryResult.append(padded).append(" ");
        }
        return binaryResult.toString().trim();
    }

    public static String binaryToText(String binary) throws NumberFormatException {
        StringBuilder textResult = new StringBuilder();
        String[] blocks = binary.split("\\s+");
        for (String block : blocks) {
            if (!block.isEmpty()) {
                int charCode = Integer.parseInt(block, 2);
                textResult.append((char) charCode);
            }
        }
        return textResult.toString();
    }

    public static void Save(long userMoney) {
        long tamperCheck = 1000000000L - userMoney;
        String userMoneyString = numberToLetters(userMoney);
        String tamperCheckString = numberToLetters(tamperCheck);
        String cipherKey1 = generateRandomKey(userMoneyString.length());
        String cipherKey2 = generateRandomKey(tamperCheckString.length());
        String userMoneyStringEncrypted = encrypt(userMoneyString, cipherKey1);
        String tamperCheckStringEncrypted = encrypt(tamperCheckString, cipherKey2);
        String cipherKey1Binary = textToBinary(cipherKey1);
        String cipherKey2Binary = textToBinary(cipherKey2);
        String userMoneyStringEncryptedBinary = textToBinary(userMoneyStringEncrypted);
        String tamperCheckStringEncryptedBinary = textToBinary(tamperCheckStringEncrypted);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GameSaveData.txt"))) {
            writer.write(cipherKey1Binary + "\n" + cipherKey2Binary + "\n" + userMoneyStringEncryptedBinary + "\n" + tamperCheckStringEncryptedBinary);
            System.out.println("\n[System] Game saved successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static long Load() {
        String cipherKey1 = "", cipherKey2 = "";
        long userMoney = 100, tamperCheck = 0;
        int count = 1;
        File file = new File("GameSaveData.txt");
        if (!file.exists()) return 100;
        try (BufferedReader br = new BufferedReader(new FileReader("GameSaveData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (count == 1) cipherKey1 = binaryToText(line);
                else if (count == 2) cipherKey2 = binaryToText(line);
                else if (count == 3) userMoney = lettersToNumber(decrypt(binaryToText(line), cipherKey1));
                else if (count == 4) {
                    tamperCheck = lettersToNumber(decrypt(binaryToText(line), cipherKey2));
                    if ((userMoney == -1 || tamperCheck == -1 || userMoney + tamperCheck != 1000000000L)) {
                        System.out.println("Tampering detected! Resetting balance.");
                        return 100;
                    }
                }
                count++;
            }
        } catch (Exception e) { return 100; }
        return userMoney;
    }

    // --- NEW HELPER CLASS FOR POKER ---
    static class Card {
        int value; // 2-14 (11=J, 12=Q, 13=K, 14=A)
        String suit;
        Card(int v, String s) { this.value = v; this.suit = s; }
        public String toString() {
            String valStr = value == 11 ? "J" : value == 12 ? "Q" : value == 13 ? "K" : value == 14 ? "A" : String.valueOf(value);
            return valStr + suit;
        }
    }

    // --- MAIN GAME LOOP ---
    public static void main(String[] args) {
        System.out.println("*********************************");
        System.out.println("  WELCOME TO THE INSECURE CASINO ");
        System.out.println("*********************************");
        long userMoney = Load();
        boolean running = true;

        while (running) {
            System.out.println("\n---------------------------------");
            System.out.println("Balance: $" + userMoney);
            System.out.println("1. Coin Flip      2. Slots         3. Higher/Lower");
            System.out.println("4. Blackjack     5. Roulette      6. Baccarat");
            System.out.println("7. Video Poker  8. Save & Exit");
            System.out.print("Choose: ");

            String choice = sc.next();
            switch (choice) {
                case "1" -> userMoney = playCoinFlip(userMoney);
                case "2" -> userMoney = playSlots(userMoney);
                case "3" -> userMoney = playHigherLower(userMoney);
                case "4" -> userMoney = playBlackjack(userMoney);
                case "5" -> userMoney = playRoulette(userMoney);
                case "6" -> userMoney = playBaccarat(userMoney);
                case "7" -> userMoney = playVideoPoker(userMoney);
                case "8" -> { Save(userMoney); running = false; }
                default -> System.out.println("Invalid option.");
            }
            if (userMoney <= 0) {
                System.out.println("\n*** YOU ARE BROKE! ***");
                Save(userMoney);
                running = false;
            }
        }
    }

    // --- ORIGINAL GAMES ---
    private static long playCoinFlip(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        System.out.print("Heads/Tails (h/t): "); String pick = sc.next().toLowerCase();
        String res = rand.nextBoolean() ? "h" : "t";
        if (pick.equals(res)) { System.out.println("WIN!"); return money + bet; }
        System.out.println("LOSE!"); return money - bet;
    }

    private static long playSlots(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        String[] sym = {"CHERRY", "LEMON", "BELL", "DIAMOND", "SEVEN"};
        String s1 = sym[rand.nextInt(5)], s2 = sym[rand.nextInt(5)], s3 = sym[rand.nextInt(5)];
        System.out.println("\n [ " + s1 + " | " + s2 + " | " + s3 + " ]");
        if (s1.equals(s2) && s2.equals(s3)) { System.out.println("JACKPOT! Won $" + (bet * 10)); return money + (bet * 10); }
        if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) { System.out.println("Small Match! Won $" + (bet * 2)); return money + (bet * 2); }
        System.out.println("No match."); return money - bet;
    }

    private static long playHigherLower(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        int r1 = rand.nextInt(6) + 1; System.out.println("Roll 1: " + r1);
        System.out.print("Higher/Lower (h/l): "); String pick = sc.next().toLowerCase();
        int r2 = rand.nextInt(6) + 1; System.out.println("Roll 2: " + r2);
        if (r2 == r1) return money;
        if ((pick.equals("h") && r2 > r1) || (pick.equals("l") && r2 < r1)) { System.out.println("WIN!"); return money + bet; }
        System.out.println("LOSE!"); return money - bet;
    }

    private static long playBlackjack(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        List<Integer> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) { for (int v = 2; v <= 11; v++) deck.add(v); deck.add(10); deck.add(10); deck.add(10); }
        Collections.shuffle(deck);
        List<Integer> pHand = new ArrayList<>(), dHand = new ArrayList<>();
        pHand.add(deck.remove(0)); dHand.add(deck.remove(0)); pHand.add(deck.remove(0)); dHand.add(deck.remove(0));
        boolean pBust = false;
        while (true) {
            int val = calculateHandValue(pHand);
            System.out.println("Hand: " + pHand + " (" + val + ") | Dealer: [" + dHand.get(0) + ", ?]");
            if (val > 21) { System.out.println("BUST!"); pBust = true; break; }
            if (val == 21) break;
            System.out.print("Hit/Stand (h/s): ");
            if (sc.next().toLowerCase().equals("h")) pHand.add(deck.remove(0)); else break;
        }
        if (!pBust) {
            while (calculateHandValue(dHand) < 17) dHand.add(deck.remove(0));
            int dVal = calculateHandValue(dHand), pVal = calculateHandValue(pHand);
            System.out.println("Dealer: " + dHand + " (" + dVal + ")");
            if (dVal > 21 || pVal > dVal) { System.out.println("WIN!"); return money + bet; }
            if (dVal > pVal) { System.out.println("LOSE!"); return money - bet; }
            System.out.println("Push!"); return money;
        }
        return money - bet;
    }

    private static int calculateHandValue(List<Integer> hand) {
        int v = 0, a = 0;
        for (int c : hand) { if (c == 11) a++; v += c; }
        while (v > 21 && a > 0) { v -= 10; a--; }
        return v;
    }

    // --- ROULETTE ---
    private static long playRoulette(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        System.out.println("Bet on: 1. Specific Number (0-36) | 2. Red/Black | 3. Even/Odd");
        int type = sc.nextInt();
        String choice = ""; int numChoice = -1;
        if (type == 1) { System.out.print("Number: "); numChoice = sc.nextInt(); }
        else if (type == 2) { System.out.print("Red/Black (r/b): "); choice = sc.next().toLowerCase(); }
        else { System.out.print("Even/Odd (e/o): "); choice = sc.next().toLowerCase(); }

        int result = rand.nextInt(37);
        String color = (result == 0) ? "green" : (result % 2 == 0 ? "black" : "red");
        System.out.println("Result: " + result + " (" + color + ")");

        if (type == 1 && result == numChoice) { System.out.println("JACKPOT! 35x!"); return money + (bet * 35); }
        if (type == 2 && choice.equals(color.substring(0, 1))) { System.out.println("WIN!"); return money + bet; }
        if (type == 3 && result != 0 && ((choice.equals("e") && result % 2 == 0) || (choice.equals("o") && result % 2 != 0))) { System.out.println("WIN!"); return money + bet; }
        
        System.out.println("LOSE!"); return money - bet;
    }

    // --- BACCARAT ---
    private static long playBaccarat(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;
        System.out.println("Bet on: 1. Player | 2. Banker | 3. Tie");
        int betSide = sc.nextInt();

        int pVal = 0, bVal = 0;
        for (int i = 0; i < 2; i++) {
            pVal += (rand.nextInt(13) + 1) % 10;
            bVal += (rand.nextInt(13) + 1) % 10;
        }
        
        // Simplified drawing rules for Baccarat
        if (pVal < 5) pVal += (rand.nextInt(13) + 1) % 10;
        if (bVal < 5) bVal += (rand.nextInt(13) + 1) % 10;
        pVal %= 10; bVal %= 10;

        System.out.println("Player: " + pVal + " | Banker: " + bVal);
        if (pVal == bVal) {
            if (betSide == 3) { System.out.println("TIE! 8x!"); return money + (bet * 8); }
            System.out.println("Push!"); return money;
        }
        int winner = (pVal > bVal) ? 1 : 2;
        if (betSide == winner) { System.out.println("WIN!"); return money + bet; }
        System.out.println("LOSE!"); return money - bet;
    }

    // --- VIDEO POKER ---
    private static long playVideoPoker(long money) {
        System.out.print("Bet: $"); long bet = sc.nextLong();
        if (bet > money || bet <= 0) return money;

        String[] suits = {"H", "D", "C", "S"};
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) hand.add(new Card(rand.nextInt(13) + 2, suits[rand.nextInt(4)]));

        System.out.println("Your hand: " + hand);
        System.out.print("Enter indices to HOLD (e.g. 0 2 4) or -1 to hold none: ");
        List<Integer> hold = new ArrayList<>();
        while (true) {
            int idx = sc.nextInt();
            if (idx == -1) break;
            hold.add(idx);
            if (hold.size() == 5) break; // limit to 5
            // Note: This is a simple input. User must enter -1 to finish.
        }
        // Since sc.nextInt() is tricky in a loop, let's just use a simple approach:
        // In a real game, we'd use sc.nextLine(), but for now:
        // (Logic below: replace cards not in 'hold')
        
        // Simplified: We will just re-draw based on a simple prompt.
        // To keep code short, let's just simulate the draw result.
        for (int i = 0; i < 5; i++) {
            if (!hold.contains(i)) hand.set(i, new Card(rand.nextInt(13) + 2, suits[rand.nextInt(4)]));
        }
        System.out.println("Final Hand: " + hand);

        // Hand Evaluation Logic
        int multiplier = evaluatePokerHand(hand);
        if (multiplier > 0) {
            System.out.println("Hand Value: " + multiplier + "x!");
            return money + (bet * multiplier);
        }
        System.out.println("Nothing. Lose!");
        return money - bet;
    }

    private static int evaluatePokerHand(List<Card> hand) {
        Collections.sort(hand, (a, b) -> a.value - b.value);
        boolean flush = true;
        for (int i = 1; i < 5; i++) if (!hand.get(i).suit.equals(hand.get(0).suit)) flush = false;
        
        boolean straight = true;
        for (int i = 1; i < 5; i++) if (hand.get(i).value != hand.get(i-1).value + 1) straight = false;

        Map<Integer, Integer> counts = new HashMap<>();
        for (Card c : hand) counts.put(c.value, counts.getOrDefault(c.value, 0) + 1);
        
        int maxCount = 0;
        for (int c : counts.values()) maxCount = Math.max(maxCount, c);

        if (flush && straight && hand.get(0).value == 10) return 800; // Royal Flush
        if (maxCount == 4) return 25;
        if (maxCount == 3 && counts.size() == 2) return 9; // Full House
        if (flush) return 5;
        if (straight) return 4;
        if (maxCount == 3) return 3;
        if (maxCount == 2 && counts.size() == 3) return 2; // Two Pair
        if (maxCount == 2 && hand.get(0).value >= 11) return 1; // Jacks or Better
        
        return 0;
    }
}
