public class Quote {

    private String name;
    private String quote;

    public Quote(String line){
        this.name = parseName(line.substring(0,line.indexOf(':')));
        this.quote = parseQuote(line.substring(line.indexOf(':')+2));
    }

    private String parseQuote(String quote) {
        //capitalize first letter:
        quote = quote.substring(0,1) + quote.substring(1,2).toUpperCase() + quote.substring(2);
        //add punctuation
        char lastChar = quote.charAt(quote.length()-2);
        if(lastChar!='!'){
            quote = quote.replaceAll("\"$",".\"");
        }
        return quote;
    }

    private String parseName(String name) {
        //strip name from "" :
        name = name.replaceAll("\"","");
        //capitalize first letter:
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        //capitalize every letter after a space:
        for(int i=0 ;i<name.length();i++){
            if(name.charAt(i)==' '){
                name = name.substring(0,i+1) + name.substring(i+1,i+2).toUpperCase() + name.substring(i+2);
            }
        }
        return name;
    }

    public void print(){
        System.out.println(quote + " -- " + name);
    }
}
