import java.util.*;

public class SocialNetwork {
    static class Graph {
        private Map<String, List<String>> network = new HashMap<>();

        public void addPerson(String person) {
            network.putIfAbsent(person, new ArrayList<>());
        }

        public void addFriendship(String person1, String person2) {
            network.get(person1).add(person2);
            network.get(person2).add(person1);
        }

        public void displayFriends(String person) {
            if (network.containsKey(person)) {
                System.out.println(person + "'s friends: " + network.get(person));
            } else {
                System.out.println(person + " is not in the network.");
            }
        }

        public void displayAllConnections() {
            for (String person : network.keySet()) {
                System.out.println(person + " -> " + network.get(person));
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Social Network Friend Finder");
        System.out.println("1. Add Person");
        System.out.println("2. Add Friendship");
        System.out.println("3. Display Friends of a Person");
        System.out.println("4. Display All Connections");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter person's name: ");
                    String person = scanner.nextLine();
                    graph.addPerson(person);
                    System.out.println(person + " added to the network.");
                    break;
                case 2:
                    System.out.print("Enter first person's name: ");
                    String person1 = scanner.nextLine();
                    System.out.print("Enter second person's name: ");
                    String person2 = scanner.nextLine();
                    graph.addFriendship(person1, person2);
                    System.out.println("Friendship added between " + person1 + " and " + person2 + ".");
                    break;
                case 3:
                    System.out.print("Enter person's name: ");
                    String name = scanner.nextLine();
                    graph.displayFriends(name);
                    break;
                case 4:
                    graph.displayAllConnections();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
