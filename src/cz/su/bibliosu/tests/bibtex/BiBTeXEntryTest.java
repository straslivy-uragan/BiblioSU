package cz.su.bibliosu.tests.bibtex;

import cz.su.bibliosu.bibtex.BiBTeXEntry;
import static junit.framework.Assert.*;

/** Test class for BiBTeXEntry.
 */
public class BiBTeXEntryTest
{
    public static void run() {
        BiBTeXEntry entry = new BiBTeXEntry();
        entry.initEntry("article", "AB09");
        assertEquals("Entry type", "article", entry.getEntryType());
        assertEquals("Entry cite-key", "AB09", entry.getCiteKey());
        entry.putTagValue("author", "Strašlivý Uragán");
        assertEquals("Tag author", "Strašlivý Uragán", entry.getTagValue("author"));
        assertEquals("Tag AUTHOR", "Strašlivý Uragán", entry.getTagValue("AUTHOR"));
        entry.setEntryType("book");
        assertEquals("Entry type", "book", entry.getEntryType());
        entry.setCiteKey("CD11b");
        assertEquals("Entry cite-key", "CD11b", entry.getCiteKey());
        entry.putTagValue("year", "1995");
        assertEquals("Tag year", "1995", entry.getTagValue("year"));
        assertEquals("Number of tags", 2, entry.numberOfTags()); 
        }
    }
}
