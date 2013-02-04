package cz.su.bibliosu.bibtex;

/** Class representing an author description within a BiBTeX file. A
 * BiBTeX author name consists of three parts, the first name, the
 * middle name, and the family name. The class implements the
 * java.lang.Comparable interfaces. The natural order of this class is
 * to be sorted first by the family name, then by the first name, and
 * then by the middle name, all names being sorted lexicographically.
 *
 * @author Strašlivý Uragán
 * @version 1.0
 * @since 1.0
 */
public class BiBTeXAuthor implements Comparable<BiBTeXAuthor> {
    /** The first name of the author.
     */
    String firstName = "";
    /** The middle name of the author.
     */
    String middleName = "";
    /** The family name of the author.
     */
    String familyName = "";

    /** Initializes an empty author object.
     */
    public BiBTeXAuthor() {
    }

    /** Initializes an author object with given first, middle, and
     * family names.
     *
     * @param firstName The first name of the author.
     * @param middleName The middle name of the author.
     * @param familyName The family name of the author.
     */
    public BiBTeXAuthor(String firstName, String middleName, String familyName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
    }

    /** Returns the first name of the author.
     *
     * @return The first name of the author.
     */
    public String getFirstName() {
        return (firstName == null ? "" : firstName);
    }

    /** Returns the middle name of the author.
     *
     * @return The middle name of the author.
     */
    public String getMiddleName() {
        return (middleName == null ? "" : middleName);
    }

    /** Returns the family name of the author.
     *
     * @return The family name of the author.
     */
    public String getFamilyName() {
        return (familyName == null ? "" : familyName);
    }

    /** Sets the first name of the author.
     *
     * @param firstName The new first name of the author.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /** Sets the middle name of the author.
     *
     * @param middleName The new middle name of the author.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    /** Sets the family name of the author.
     *
     * @param familyName The new family name of the author.
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(BiBTeXAuthor author) {
        if (author == null) {
            return -1;
        }
        int comp = getFamilyName().compareTo(author.getFamilyName());
        if (comp == 0) {
            comp = getFirstName().compareTo(author.getFirstName());
            if (comp == 0) {
                comp = getMiddleName().compareTo(author.getMiddleName());
            }
        }
        return comp;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof BiBTeXAuthor)) {
            return false;
        }
        BiBTeXAuthor lhs = (BiBTeXAuthor) object;
        return getFamilyName().equals(lhs.getFamilyName())
            && getFirstName().equals(lhs.getFirstName())
            && getMiddleName().equals(lhs.getMiddleName());
    }
}
