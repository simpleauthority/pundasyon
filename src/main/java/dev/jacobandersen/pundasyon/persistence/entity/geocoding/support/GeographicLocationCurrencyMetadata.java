package dev.jacobandersen.pundasyon.persistence.entity.geocoding.support;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geographic_location_currency_metadata")
@AllArgsConstructor
@Builder
public class GeographicLocationCurrencyMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_metadata_id", nullable = false)
    private long currencyMetadataId;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "unambiguous_symbol")
    private String unambiguousSymbol;

    @Column(name = "place_symbol_first")
    private boolean placeSymbolFirst;

    @Column(name = "decimal_mark")
    private String decimalMark;

    @Column(name = "thousands_separator")
    private String thousandsSeparator;

    @Column(name = "smallest_denomination")
    private int smallestDenomination;

    @Column(name = "subunit_name")
    private String subunitName;

    @Column(name = "subunit_to_unit")
    private int subunitToUnit;

    protected GeographicLocationCurrencyMetadata() {}

    public GeographicLocationCurrencyMetadata(String name, String symbol, String unambiguousSymbol, boolean placeSymbolFirst, String decimalMark, String thousandsSeparator, int smallestDenomination, String subunitName, int subunitToUnit) {
        this.name = name;
        this.symbol = symbol;
        this.unambiguousSymbol = unambiguousSymbol;
        this.placeSymbolFirst = placeSymbolFirst;
        this.decimalMark = decimalMark;
        this.thousandsSeparator = thousandsSeparator;
        this.smallestDenomination = smallestDenomination;
        this.subunitName = subunitName;
        this.subunitToUnit = subunitToUnit;
    }

    /**
     * A unique ID representing this currency metadata.
     * @return the currency metadata ID
     */
    public long getCurrencyMetadataId() {
        return currencyMetadataId;
    }

    /**
     * Gets the name of the currency used at the connected location.
     * @return the currency name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the symbol representing the currency used at the connected location.
     * @return the currency symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets an unambiguous symbol that represents the currency used at the connected location.
     * <p><strong>Example</strong>: The New Zealand dollar has the symbol "$" but the unambiguous symbol is NZ$.</p>
     * @return the disambiguated symbol
     */
    public String getUnambiguousSymbol() {
        return unambiguousSymbol;
    }

    /**
     * Whether to place the currency symbol at the beginning of the value.
     * @return true or false
     */
    public boolean isPlaceSymbolFirst() {
        return placeSymbolFirst;
    }

    /**
     * Gets the mark used to indicate decimal values in the currency.
     * @return the decimal mark
     */
    public String getDecimalMark() {
        return decimalMark;
    }

    /**
     * Gets the mark used to indicate separations of thousands in the currency.
     * @return the thousands separator
     */
    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    /**
     * Gets the smallest denomination offered in the currency.
     * @return the smallest denomination
     */
    public int getSmallestDenomination() {
        return smallestDenomination;
    }

    /**
     * Gets the name of the subunit of the currency.
     * <p><strong>Example</strong>: For example, the US Dollar has the subunit Cents.</p>
     * @return the subunit name
     */
    public String getSubunitName() {
        return subunitName;
    }

    /**
     * Gets the amount of subunits that make up a single unit of the currency.
     * <p><strong>Example</strong>: For example, the 100 Cents make up one US Dollar.</p>
     * @return the amount of subunits in a unit
     */
    public int getSubunitToUnit() {
        return subunitToUnit;
    }

    @Override
    public String toString() {
        return "GeographicLocationCurrencyMetadata{" +
                "currencyMetadataId=" + currencyMetadataId +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", unambiguousSymbol='" + unambiguousSymbol + '\'' +
                ", placeSymbolFirst=" + placeSymbolFirst +
                ", decimalMark='" + decimalMark + '\'' +
                ", thousandsSeparator='" + thousandsSeparator + '\'' +
                ", smallestDenomination=" + smallestDenomination +
                ", subunitName='" + subunitName + '\'' +
                ", subunitToUnit=" + subunitToUnit +
                '}';
    }
}
