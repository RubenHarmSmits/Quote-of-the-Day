import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuoteOfTheDay {

    public static void main(String[] args) throws IOException {
        new QuoteOfTheDay().printQuote();
    }

    ArrayList<Quote> quotes;
    LocalDate today = LocalDate.now();

    private void printQuote() throws IOException {
        quotes = makeQuotes();
        System.out.println(makeIntro());
        quotes.get(checkIndex()).print();
    }

    private String makeIntro() {
        String dayOfWeek = fixCapitals(today.getDayOfWeek().toString());
        String dayOfMonth = today.getDayOfMonth()+ makeOrdinal(today.getDayOfMonth());
        String month = fixCapitals(today.getMonth().toString());
        return "Quote for " + fixCapitals(dayOfWeek) + " the " +dayOfMonth  + " of " + month + ":" ;
    }

    private String fixCapitals(String word){
        word = word.toLowerCase();
        word = word.substring(0,1).toUpperCase() + word.substring(1);
        return word;
    }

    private int checkIndex() {
        int dayOfYear = today.getDayOfYear();
        return (dayOfYear-1) % 6;
    }

    private ArrayList<Quote> makeQuotes() throws IOException {
        ArrayList<Quote> quotes = new ArrayList<>();
        File fl = new File("quotes.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String line;
        while((line = br.readLine())!=null){
            quotes.add(new Quote(line));
        }
        return quotes;
    }

    private String makeOrdinal(int number) {
        switch (number % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }
}
