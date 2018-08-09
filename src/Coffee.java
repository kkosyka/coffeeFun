import java.util.*;

public class Coffee {

    public static class CoffeeShops{
        private ArrayList<String> toVisit;
        private ArrayList<String> visited;
        private Map<String, String[]> ToVisit;
        private Map<String, String[]> Visited;
        private CoffeeParticipants participants;


        public CoffeeShops(CoffeeParticipants participants){
            this.toVisit = new ArrayList<>();
            this.visited = new ArrayList<>();
            this.ToVisit = new HashMap<String, String[]>();
            this.Visited = new HashMap<String, String[]>();
            this.participants = participants;

        }

        public void addShop(String name){
            toVisit.add(name);
            ToVisit.put(name, new String[]{"-","-","-"});
        }

        public void markVisited(String name){
            toVisit.remove(name);
            visited.add(name);
        }

        public void markVisited(String name, String[] rating){
            ToVisit.remove(name);
            Visited.put(name, rating);
        }

        public void showToVisit(){
            System.out.println("TO VISIT");
            if(toVisit.size() == 0){
                System.out.println("empty list");
            }
            for (int i = 0; i < toVisit.size(); i++) {

                System.out.println(i+1 + ". " + toVisit.get(i));
            }
            System.out.println();
        }

        public void showVisited(){
            System.out.println("VISITED");
            if(visited.size() == 0){
                System.out.println("empty list");
            }
            for (int i = 0; i < visited.size(); i++) {
                System.out.println(i+1 + ". " + visited.get(i));
            }
            System.out.println();
        }

        public void showToVisit1(){
            System.out.println("TO VISIT");
            String rank = "";
            for(String person: participants.getParticipants()){
                rank += person.split(" ")[0] + "'s Rank | ";
            }
            System.out.println(String.format("%-30s| %-5s", "Shop", rank));
            System.out.println(String.format("%-30s|%-5s|%-5s|%-5s|", String.join("", Collections.nCopies(30, "-")), String.join("", Collections.nCopies(15, "-")),String.join("", Collections.nCopies(16, "-")), String.join("", Collections.nCopies(19, "-"))));
            for (Map.Entry<String, String[]> toVisit : ToVisit.entrySet()) {
                System.out.println(String.format("%-30s| %-14s| %-15s| %-18s|", toVisit.getKey(), toVisit.getValue()[0],toVisit.getValue()[1], toVisit.getValue()[2]));
            }
            System.out.println();
        }

        public void showVisited1(){
            System.out.println("VISITED");
            String rank = "";
            for(String person: participants.getParticipants()){
                rank += person.split(" ")[0] + "'s Rank | ";
            }
            System.out.println(String.format("%-30s| %-5s", "Shop", rank));
            System.out.println(String.format("%-30s|%-5s|%-5s|%-5s|", String.join("", Collections.nCopies(30, "-")), String.join("", Collections.nCopies(15, "-")),String.join("", Collections.nCopies(16, "-")), String.join("", Collections.nCopies(19, "-"))));
            for (Map.Entry<String, String[]> visited : Visited.entrySet()) {
                System.out.println(String.format("%-30s| %-14s| %-15s| %-18s|", visited.getKey(), visited.getValue()[0],visited.getValue()[1], visited.getValue()[2]));
            }
            System.out.println();
        }


        public void summary(){
//            showToVisit();
//            showVisited();

            showToVisit1();
            showVisited1();

        }
    }


    public static class CoffeeParticipants{
        private ArrayList<String> participants;
        private int count;

        public CoffeeParticipants(){
            this.participants = new ArrayList<>();
        }

        public void addParticipant(String name){
            participants.add(name);
        }

        public void removeParticipant(String name){
            participants.remove(name);
        }

        public void showParticipants() {
            System.out.println("LIST OF PARTICIPANTS");
            for (int i = 0; i < participants.size(); i++) {
                System.out.println(String.format("%-2s| %-30s", i+1, participants.get(i)));
            }
            System.out.println();
        }

        public ArrayList<String> getParticipants(){
            return this.participants;
        }

        public int countParticipants(){
            return participants.size();
        }

    }


    public static void main(String[] args){
        CoffeeParticipants participants = new CoffeeParticipants();
        String[] participantsList = {"Kalynn Kosyka", "Kaimeng Cao", "Harmanjeet Singh Dhillon"};
        for(String participant :  participantsList){
            participants.addParticipant(participant);
        }
        participants.showParticipants();

        CoffeeShops shops = new CoffeeShops(participants);
        String[] shopList = {"Verrilli's Bakery", "Saigon Subs & Café", "Smartworld Coffee"};
        for(String shop :  shopList){
            shops.addShop(shop);
        }

        shops.markVisited("Verrilli's Bakery", new String[]{"7","-","6.4"});
        shops.summary();

    }
}
