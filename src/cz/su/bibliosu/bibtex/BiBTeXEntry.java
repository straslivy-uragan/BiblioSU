package cz.su.bibliosu.bibtex;

import java.util.Map;
import java.util.TreeMap;

/** Class representing a single BiBTeX file entry. The main elements
 * of the entry are the entry type such as article, inproceedings etc.
 * and cite-key. Both are stored as strings. It would be very
 * complicated to give a list of possible types and store them as a
 * constant int value as the possible types are not bounded by the
 * BiBTeX specification. Cite-key is stored as string as well. The
 * last important part is the map mapping the string values of tags to
 * their names (key is the name of a tag).
 *
 * This class implements the Comparable interface so that the natural
 * order of the BiBTeXEntries is defined. Naturally the entries are
 * sorted by their cite-keys lexicographically.
 */
public class BiBTeXEntry implements Comparable<BiBTeXEntry>
{
    /** Type of the entry. The string with type is stored without
     * leading @.
     */
	String entryType;
    /** Cite-key of the publication.
     */
    String citeKey;
    /** Tags mapped by their names. Stored sorted by keys, i.e. the
     * tag names so that we can easily get the sorted list of keys.
     */
    Map<String,String> tags = new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);

    /** Initializes an empty entry. */
    public BiBTeXEntry() {
    }

    /** Initializes an entry with given type and cite-key. It also
     * clears the <code>tags</code> map.
     *
     * @param entryType New type of the entry.
     * @param citeKey New cite-key of the entry.
     */
    public void initEntry(String entryType, String citeKey) {
        this.entryType = entryType;
        this.citeKey = citeKey;
        tags.clear();
    }

    /** Returns the type of this entry.
     *
     * @return Type of this entry.
     */
    public String getEntryType() {
        return (entryType == null ? "" : entryType);
    }

    /** Returns the cite-key of this entry.
     *
     * @return Cite-key of this entry.
     */
    public String getCiteKey() {
        return (citeKey == null ? "" : citeKey);
    }

    /** Returns the tag value for given name.
     *
     * @param name Name of the tag whose value should be returned.
     * @return Value of tag with name <code>name</code>, or
     * <code>null</code> if no such entry exists.
     */
    public String getTagValue(String name) {
        return tags.get(name);
    }

    /** Sets the type of this entry.
     *
     * @param entryType New type of this entry.
     */
    public void setEntryType (String entryType) {
        this.entryType = entryType;
    }

    /** Sets the cite-key of this entry.
     *
     * @param citeKey New cite-key of this entry.
     */
    public void setCiteKey(String citeKey) {
        this.citeKey = citeKey;
    }

    /** Sets the value of tag with given name to given value.
     * If the tag identified by <code>name</code> does not exist, it
     * is added to the <code>tags</code> <code>Map</code>.
     *
     * @param name Name of the tag to modify.
     * @param value New value of the tag identified by
     * <code>name</code>.
     */
    public void putTagValue(String name, String value) {
        tags.put(name, value);
    }

    /** Removes tag with given name from the <code>tags</code> map.
     *
     * @param name Name of the tag to be removed.
     */
    public void removeTag(String name) {
        tags.remove(name);
    }

    /** Removes all tags from the <code>tags</code> map.
     */
    public void clearTags() {
        tags.clear();
    }

    /** Returns the number of tags associated with the entry with set
     * value.
     *
     * @return Number of tags associated with the entry with set
     * value.
     */
    public int numberOfTags() {
        return tags.size();
    }

    /** Compares thie entry to the given one. This comparator defines
     * natural order of BiBTeXEntries, which is by their cite-key.
     *
     * @param entry Entry to compare to. 
     */
    @Override
    public int compareTo(BiBTeXEntry entry)
	{
		return getEntryType().compareTo(entry.getEntryType());
	}

	/** Compares this object to the given one. First checks if <code>object</code> is also a BiBTeXEntry.
	 * If so, this method compares entry type, cite-key and then contents of tags map against the objects elements.
	 *
	 * @param object Object to compare with.
	 *
	 * @return True if this object is equivalent to <code>object</code>, false otherwise.
	 */
    @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || !(object instanceof BiBTeXEntry)) {
                return false;
            }
            BiBTeXEntry lhs = (BiBTeXEntry) object;
            if (! getEntryType().equalsIgnoreCase(lhs.getEntryType())
                    || ! getCiteKey().equalsIgnoreCase(lhs.getCiteKey())) {
                return false;
            }
            if (numberOfTags() != lhs.numberOfTags()) {
                return false;
            }
            Map<String,String> lhsTags = lhs.tags;
            for (Map.Entry<String,String> aTag : tags.entrySet()) {
                if (! lhsTags.containsKey(aTag.getKey()) ||
						! lhsTags.get(aTag.getKey()).equalsIgnoreCase(aTag.getValue())) {
                   return false;
                }
            }
			return true;
        }
}

