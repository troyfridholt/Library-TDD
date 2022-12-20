package Services;



public class Library {

    public void main(String[] args){
    Books bookOne = new Books("Survival quest", "Vasily Mahanenko", "Fantasy", "2015", 5, true);
    Books bookTwo = new Books("Agile People", "Pia-Maria Thoren","Unknown", "2017", 5, false);
    Books bookThree = new Books("The Mountain Is You","Brianna Wiest ","Unknown", "2020", 4, true);
    Books bookFour = new Books("A Tale of Two Cities", "Charles Dickens", "Fantasy", "1859", 2, true);
    Books bookFive = new Books("The Little Prince", "Antoine de Saint-Exupéry", "novel", "1943", 5, true);

    Books.books.add(bookOne);
    Books.books.add(bookTwo);
    Books.books.add(bookThree);
    Books.books.add(bookFour);
    Books.books.add(bookFive);

    }
    public static boolean searchTitle(String title){
        boolean isBookAvailable = false;
        for (int i = 0; i < Books.books.size(); i++){
            if (title.equals(Books.books.get(i).getTitle()) && Books.books.get(i).isAvailable()){
                isBookAvailable = true;
                System.out.println(title + "Available");

                return isBookAvailable;
            }
        }System.out.println(title + "Not available");
        return isBookAvailable;
    }
    public static boolean searchAuthor(String author){
        boolean inOrOut = false;

        for (int i = 0; i < Books.books.size(); i++)
            if (author.equals(Books.books.get(i).getAuthor()) && Books.books.get(i).isAvailable()) {
                inOrOut = true;
                System.out.println(author + " Is Available");
                return inOrOut;
            }
        System.out.println(author + " Is not here");
        return inOrOut;
    }
    public static boolean searchForDateAndIfHere(String date) {
        boolean inOrOut = false;
        for (int i = 0; i < Books.books.size(); i++) {
            if (date.equals(Books.books.get(i).getReleaseDate()) && Books.books.get(i).isAvailable() == true) {
                inOrOut = true;
                System.out.println("'" + Books.books.get(i).getTitle() + "'" + " released in " + date + " here.");
                return inOrOut;
            }
        }
        System.out.println(date + " not here");

        return inOrOut;

    }

    public static boolean borrowBook(){
        String bookTest = "Survival quest";
        for (int i = 0; i < Books.books.size(); i++){
            if(bookTest.equals(Books.books.get(i).getTitle()) && Books.books.get(i).isAvailable()){
                System.out.println(Books.books.get(i).getTitle() + "Have been borrowed.");
                return true;
            }
            else{
                System.out.println("Not possible at this moment.");
            }
        }return false;

    }
    public static void leaveReview(){
        String bookTest = "Survival quest";
        int updatedRating = 5;
        String addReview = "New comment added";

        for (int i = 0; i < Books.books.size(); i++){
            if(bookTest.equals(Books.books.get(i).getTitle())){
                Books.books.get(i).setRating(updatedRating);
                Books.books.get(i).setReviews(addReview);
                System.out.println(Books.books.get(i) +  "Of 7");
                System.out.println(Books.books.get(i).getReviews());
                break;
            }else{
                System.out.println("Could not add comment");
            }
        }
    }
    public static int highestRating(){
        int highestRating = 7;
        String y="";

        for(int j=0; j< Books.books.size(); j++){
            if (Books.books.get(j).getRating()>highestRating){
                highestRating=Books.books.get(j).getRating();
                y=Books.books.get(j).getTitle();
            }
        }
        System.out.println("Highest rated book is "+"'" + y + "'" + "Which is rated" + highestRating);
  return highestRating;
    }

}
