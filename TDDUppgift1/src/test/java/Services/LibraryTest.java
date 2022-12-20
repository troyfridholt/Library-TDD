package Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibraryTest {




    @BeforeEach
    public void addBook(){
        Books bookOne = new Books("Survival quest", "Vasily Mahanenko", "Fantasy", "2015", 5, true);
        Books.books.add(bookOne);
        assertEquals("Survival quest", bookOne.getTitle());
    }

    @Test
    public void searchForTitle(){
        assertTrue(Library.searchTitle("Survival quest"));
    }

    @Test
    public void searchForTitleThatDoesNotExist(){
        assertFalse(Library.searchTitle("Not in library"));
    }

    @Test
    public void borrowABookFromTheLibrary(){
        assertTrue(Library.borrowBook());
    }
    @Test
    public void searchForAuthor(){
        assertTrue(Library.searchAuthor("Vasily Mahanenko"));
    }
    @Test
    public void searchForDate(){
        assertTrue(Library.searchForDateAndIfHere("2015"));
    }
    @Test
    public void highestRatingFunction(){
        assertEquals(7, Library.highestRating());
    }
    @Test
    public void borrowBook(){
        assertTrue(Library.borrowBook());
    }
    @Test
    public void commentTest(){
        Library.leaveReview();
        assertEquals(5, Books.books.get(0).getRating());
        assertEquals("New comment added", Books.books.get(0).getReviews());
    }
}