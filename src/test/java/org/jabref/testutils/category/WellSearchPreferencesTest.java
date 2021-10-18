package org.jabref.testutils.category;

import org.jabref.gui.search.SearchDisplayMode;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.model.search.rules.SearchRules;
import org.jabref.model.search.rules.SearchRules.SearchFlags;
import org.jabref.preferences.SearchPreferences;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WellSearchPreferencesTest {

    private SearchPreferences searchPreferences;
    private SearchDisplayMode searchDisplayMode = mock(SearchDisplayMode.class);
    private  boolean isCaseSensitive = false;
    private boolean isRegularExpression = false ;
    private  boolean isFulltext = false ;
    private  boolean isKeepSearchString = false ;
    private  boolean keepWindowOnTop = false;
    private SearchRules searchRules = mock(SearchRules.class);
    private EnumSet<SearchFlags> SearchRules;
    private EnumSet<SearchFlags> searchFlags;
    private boolean isKeepWindowOnTop = false;

    @BeforeEach
    void setUp() {

        searchPreferences = new SearchPreferences(searchDisplayMode,isCaseSensitive,isRegularExpression,isFulltext,isKeepSearchString, keepWindowOnTop);
        searchFlags = EnumSet.noneOf(SearchFlags.class);

        //searchFlags = searchPreferences.getSearchFlags();
       // searchFlags.contains(SearchRules.SearchFlags.REGULAR_EXPRESSION
    }


    @Test
    void getSearchDisplayMode() {
        assertEquals(searchDisplayMode, searchPreferences.getSearchDisplayMode());


    }

    @Test
    void isCaseSensitive() {
        // isCaseSensitive is true
        isCaseSensitive = true;
        searchPreferences = new SearchPreferences(searchDisplayMode,isCaseSensitive,isRegularExpression,isFulltext,isKeepSearchString, keepWindowOnTop);

        assertEquals(true, searchPreferences.isCaseSensitive());
    }

    @Test
    void isRegularExpression() {
        isRegularExpression = true;
        searchPreferences = new SearchPreferences(searchDisplayMode,isCaseSensitive,isRegularExpression,isFulltext,isKeepSearchString, keepWindowOnTop);

        assertEquals(true, searchPreferences.isRegularExpression());


    }

    @Test
    void isFulltext() {
         isFulltext = true;
        searchPreferences = new SearchPreferences(searchDisplayMode,isCaseSensitive,isRegularExpression,isFulltext,isKeepSearchString, keepWindowOnTop);

        assertEquals(true, searchPreferences.isFulltext());
    }

    @Test
    void isKeepSearchString() {
        isKeepSearchString = true;
        searchPreferences = new SearchPreferences(searchDisplayMode,isCaseSensitive,isRegularExpression,isFulltext,isKeepSearchString, keepWindowOnTop);
        assertEquals(true, searchPreferences.isKeepSearchString());
    }

    @Test
    void isKeepWindowOnTop() {
    }

    @Test
    void getSearchFlags() {
        searchPreferences = new SearchPreferences( searchDisplayMode,  searchFlags,  keepWindowOnTop);
        System.out.println("REgular Expresssion on");

        assertInstanceOf(SearchPreferences.class, searchPreferences);
        System.out.println("teste"+searchFlags);

       searchFlags = searchPreferences.getSearchFlags();

        if (!searchFlags.contains(SearchFlags.REGULAR_EXPRESSION)){
          System.out.println("REgular Expresssion not");

        }

        if (searchFlags.contains(SearchFlags.CASE_SENSITIVE)){
            System.out.println(" CASE_SENSITIVE not");
        }

        searchPreferences.withRegularExpression(true);
        searchFlags = searchPreferences.getSearchFlags();
        System.out.println("teste"+searchFlags);
        if (searchFlags.contains(SearchFlags.REGULAR_EXPRESSION)){
            System.out.println("REgular Expresssion on");
        }
        if (searchFlags.contains(SearchFlags.FULLTEXT)){
            System.out.println("FULLTEXT not");
        }
        if (searchFlags.contains(SearchFlags.REGULAR_EXPRESSION)){
            System.out.println("REGULAR_EXPRESSION not");
        }
        if (searchFlags.contains(SearchFlags.KEEP_SEARCH_STRING)){
            System.out.println("KEEP_SEARCH_STRING not");
        }



    }

    @Test
    void withSearchDisplayMode() {

        searchPreferences= searchPreferences.withSearchDisplayMode(searchDisplayMode);
        assertInstanceOf(SearchPreferences.class, searchPreferences);

    }

    @Test
    void withCaseSensitive() {
        isCaseSensitive = true;
        searchPreferences= searchPreferences.withCaseSensitive(isCaseSensitive);
        assertTrue(searchPreferences.isCaseSensitive());
        assertInstanceOf(SearchPreferences.class, searchPreferences);

    }

    @Test
    void withRegularExpression() {
        isRegularExpression = true;
        searchPreferences= searchPreferences.withRegularExpression(isRegularExpression);
        assertTrue(searchPreferences.isRegularExpression());
        assertInstanceOf(SearchPreferences.class, searchPreferences);
    }

    @Test
    void withFulltext() {
        isFulltext = true;
        searchPreferences= searchPreferences.withFulltext(isFulltext);
        assertTrue(searchPreferences.isFulltext());
        assertInstanceOf(SearchPreferences.class, searchPreferences);
    }

    @Test
    void withKeepSearchString() {
        isKeepSearchString = true;
        searchPreferences= searchPreferences.withKeepSearchString(isKeepSearchString);
        assertTrue(searchPreferences.isKeepSearchString());
        assertInstanceOf(SearchPreferences.class, searchPreferences);
    }

    @Test
    void withKeepGlobalSearchDialogOnTop() {
        isKeepWindowOnTop = true;
        searchPreferences= searchPreferences.withKeepGlobalSearchDialogOnTop(isKeepWindowOnTop);
        assertTrue(searchPreferences.isKeepWindowOnTop());
        assertInstanceOf(SearchPreferences.class, searchPreferences);

    }
}
