package utility;


import model.Continent;
import model.Country;
import model.Type;

// [0-9]+,[0-9A-Z]+,(ballon_port|closed|heliport|large_airport|medium_airport|seaplane_base|small_airport),[A-Za-z0-9' \/\(\)]+,[-0-9.]*,[-0-9.]*,[0-9]*,(AF|AN|AS|EU|NA|OC|SA)?,(AC|AD|AE|AF|AG|AI|AL|AM|AO|AQ|AR|AS|AT|AU|AW|AX|AZ|BA|BB|BD|BE|BF|BG|BH|BI|BJ|BM|BN|BO|BQ|BR|BS|BT|BV|BW|BY|BZ|CA|CC|CD|CF|CG|CH|CI|CK|CL|CM|CN|CO|CR|CU|CV|CY|CZ|DE|DJ|DK|DM|DO|DZ|EC|EE|EG|EH|ER|ES|ET|FI|FJ|FK|FM|FO|FR|GA|GB|GD|GE|GF|GG|GH|GI|GL|GM|GN|GP|GQ|GR|GT|GU|GW|GY|HK|HM|HN|HR|HT|HU|ID|IE|IL|IM|IN|IO|IQ|IR|IS|IT|JE|JM|JO|JP|KE|KG|KH|KI|KM|KN|KP|KR|KW|KY|KZ|LA|LB|LC|LI|LK|LR|LS|LT|LU|LV|LY|MA|MC|MD|ME|MF|MG|MH|MK|ML|MM|MN|MO|MP|MQ|MR|MS|MT|MU|MV|MW|MX|MY|MZ|NA|NC|NE|NF|NG|NI|NL|NO|NP|NR|NU|NZ|OM|PA|PE|PF|PG|PH|PK|PL|PM|PN|PR|PS|PT|PW|PY|QA|RE|RO|RS|RU|RW|SA|SB|SC|SD|SE|SG|SH|SI|SJ|SK|SL|SM|SN|SO|SR|SS|ST|SV|SX|SY|SZ|TC|TD|TF|TG|TH|TJ|TK|TL|TM|TN|TO|TR|TT|TV|TW|TZ|UA|UG|US|UY|UZ|VA|VC|VE|VG|VI|VN|VU|WF|WS|YE|YT|ZA|ZM|ZW),(AC|AD|AE|AF|AG|AI|AL|AM|AO|AQ|AR|AS|AT|AU|AW|AX|AZ|BA|BB|BD|BE|BF|BG|BH|BI|BJ|BM|BN|BO|BQ|BR|BS|BT|BV|BW|BY|BZ|CA|CC|CD|CF|CG|CH|CI|CK|CL|CM|CN|CO|CR|CU|CV|CY|CZ|DE|DJ|DK|DM|DO|DZ|EC|EE|EG|EH|ER|ES|ET|FI|FJ|FK|FM|FO|FR|GA|GB|GD|GE|GF|GG|GH|GI|GL|GM|GN|GP|GQ|GR|GT|GU|GW|GY|HK|HM|HN|HR|HT|HU|ID|IE|IL|IM|IN|IO|IQ|IR|IS|IT|JE|JM|JO|JP|KE|KG|KH|KI|KM|KN|KP|KR|KW|KY|KZ|LA|LB|LC|LI|LK|LR|LS|LT|LU|LV|LY|MA|MC|MD|ME|MF|MG|MH|MK|ML|MM|MN|MO|MP|MQ|MR|MS|MT|MU|MV|MW|MX|MY|MZ|NA|NC|NE|NF|NG|NI|NL|NO|NP|NR|NU|NZ|OM|PA|PE|PF|PG|PH|PK|PL|PM|PN|PR|PS|PT|PW|PY|QA|RE|RO|RS|RU|RW|SA|SB|SC|SD|SE|SG|SH|SI|SJ|SK|SL|SM|SN|SO|SR|SS|ST|SV|SX|SY|SZ|TC|TD|TF|TG|TH|TJ|TK|TL|TM|TN|TO|TR|TT|TV|TW|TZ|UA|UG|US|UY|UZ|VA|VC|VE|VG|VI|VN|VU|WF|WS|YE|YT|ZA|ZM|ZW)-[A-Z]{2},[A-Za-z]+,[0-9]*,[0-9]*,[A-Z]*,(0|1)
public interface RegexPatterns {
    String GROUP_OPENING_CHAR = "(";
    String GROUP_CLOSING_CHAR = ")";
    String OR = "|";
    String OPTIONAL_CHAR = "?";
    String ID_PATTERN = "[0-9]+";
    String AIRPORT_IDENT_PATTERN = "[0-9A-Z]+";
    String TYPE_PATTERN = getTypePattern();
    String NAME_PATTERN = String.format("[^%s]+", Constant.SEPARATOR);
    String LONGITUDE_PATTERN = "[-0-9.]*";
    String LATITUDE_PATTERN = "[-0-9.]*";
    String ELEVATION_PATTERN = "[0-9.]*";
    String CONTINENT_PATTERN = getContinentPattern();
    String COUNTRY_PATTERN = getCountryPattern();
    String REGION_PATTERN = COUNTRY_PATTERN + "-" + "[A-Z]{2}";
    String MUNICIPALITY_PATTERN = NAME_PATTERN;
    String WIDTH_PATTERN = "[0-9]*";
    String HEIGHT_PATTERN = "[0-9]*";
    String RUNWAY_SURFACE_PATTERN = "[-A-Za-z]*";
    String RUNWAY_LIGHTED_PATTERN = "(0|1)?";
    // [0-9]+,[0-9A-Z]+,(ballon_port|closed|heliport|large_airport|medium_airport|seaplane_base|small_airport),[A-Za-z0-9' \/]+,[-0-9.]*,[-0-9.]*,[0-9]*,(AF|AN|AS|EU|NA|OC|SA)?,(AC|AD|AE|AF|AG|AI|AL|AM|AO|AQ|AR|AS|AT|AU|AW|AX|AZ|BA|BB|BD|BE|BF|BG|BH|BI|BJ|BM|BN|BO|BQ|BR|BS|BT|BV|BW|BY|BZ|CA|CC|CD|CF|CG|CH|CI|CK|CL|CM|CN|CO|CR|CU|CV|CY|CZ|DE|DJ|DK|DM|DO|DZ|EC|EE|EG|EH|ER|ES|ET|FI|FJ|FK|FM|FO|FR|GA|GB|GD|GE|GF|GG|GH|GI|GL|GM|GN|GP|GQ|GR|GT|GU|GW|GY|HK|HM|HN|HR|HT|HU|ID|IE|IL|IM|IN|IO|IQ|IR|IS|IT|JE|JM|JO|JP|KE|KG|KH|KI|KM|KN|KP|KR|KW|KY|KZ|LA|LB|LC|LI|LK|LR|LS|LT|LU|LV|LY|MA|MC|MD|ME|MF|MG|MH|MK|ML|MM|MN|MO|MP|MQ|MR|MS|MT|MU|MV|MW|MX|MY|MZ|NA|NC|NE|NF|NG|NI|NL|NO|NP|NR|NU|NZ|OM|PA|PE|PF|PG|PH|PK|PL|PM|PN|PR|PS|PT|PW|PY|QA|RE|RO|RS|RU|RW|SA|SB|SC|SD|SE|SG|SH|SI|SJ|SK|SL|SM|SN|SO|SR|SS|ST|SV|SX|SY|SZ|TC|TD|TF|TG|TH|TJ|TK|TL|TM|TN|TO|TR|TT|TV|TW|TZ|UA|UG|US|UY|UZ|VA|VC|VE|VG|VI|VN|VU|WF|WS|YE|YT|ZA|ZM|ZW),(AC|AD|AE|AF|AG|AI|AL|AM|AO|AQ|AR|AS|AT|AU|AW|AX|AZ|BA|BB|BD|BE|BF|BG|BH|BI|BJ|BM|BN|BO|BQ|BR|BS|BT|BV|BW|BY|BZ|CA|CC|CD|CF|CG|CH|CI|CK|CL|CM|CN|CO|CR|CU|CV|CY|CZ|DE|DJ|DK|DM|DO|DZ|EC|EE|EG|EH|ER|ES|ET|FI|FJ|FK|FM|FO|FR|GA|GB|GD|GE|GF|GG|GH|GI|GL|GM|GN|GP|GQ|GR|GT|GU|GW|GY|HK|HM|HN|HR|HT|HU|ID|IE|IL|IM|IN|IO|IQ|IR|IS|IT|JE|JM|JO|JP|KE|KG|KH|KI|KM|KN|KP|KR|KW|KY|KZ|LA|LB|LC|LI|LK|LR|LS|LT|LU|LV|LY|MA|MC|MD|ME|MF|MG|MH|MK|ML|MM|MN|MO|MP|MQ|MR|MS|MT|MU|MV|MW|MX|MY|MZ|NA|NC|NE|NF|NG|NI|NL|NO|NP|NR|NU|NZ|OM|PA|PE|PF|PG|PH|PK|PL|PM|PN|PR|PS|PT|PW|PY|QA|RE|RO|RS|RU|RW|SA|SB|SC|SD|SE|SG|SH|SI|SJ|SK|SL|SM|SN|SO|SR|SS|ST|SV|SX|SY|SZ|TC|TD|TF|TG|TH|TJ|TK|TL|TM|TN|TO|TR|TT|TV|TW|TZ|UA|UG|US|UY|UZ|VA|VC|VE|VG|VI|VN|VU|WF|WS|YE|YT|ZA|ZM|ZW)-[A-Z]{2},[A-Za-z]+,[0-9]*,[0-9]*,[A-Z]*,(0|1)
    String VALID_DATASET_PATTERN = ID_PATTERN +
            Constant.SEPARATOR +
            AIRPORT_IDENT_PATTERN +
            Constant.SEPARATOR +
            TYPE_PATTERN +
            Constant.SEPARATOR +
            NAME_PATTERN +
            Constant.SEPARATOR +
            LONGITUDE_PATTERN +
            Constant.SEPARATOR +
            LATITUDE_PATTERN +
            Constant.SEPARATOR +
            ELEVATION_PATTERN +
            Constant.SEPARATOR +
            CONTINENT_PATTERN +
            Constant.SEPARATOR +
            COUNTRY_PATTERN +
            Constant.SEPARATOR +
            REGION_PATTERN +
            Constant.SEPARATOR +
            MUNICIPALITY_PATTERN +
            Constant.SEPARATOR +
            WIDTH_PATTERN +
            Constant.SEPARATOR +
            HEIGHT_PATTERN +
            Constant.SEPARATOR +
            RUNWAY_SURFACE_PATTERN +
            Constant.SEPARATOR +
            RUNWAY_LIGHTED_PATTERN +
            Constant.SEPARATOR;



    private static String getTypePattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING_CHAR);
        Type[] types = Type.values();
        for (Type type : types) {
            pattern.append(type.toString().toLowerCase()).append(OR);
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING_CHAR);
        return pattern.toString();
    }

    private static String getContinentPattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING_CHAR);
        for (Continent continent :  Continent.values()) {
            pattern.append(continent.toString()).append(OR);
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING_CHAR);
        pattern.append(OPTIONAL_CHAR);
        return pattern.toString();
    }

    private static String getCountryPattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING_CHAR);
        for (Country country : Country.values()) {
            pattern.append(country.toString(), Constant.startCountryISOString, Constant.endCountryISOString).append(OR);
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING_CHAR);
        return pattern.toString();
    }


}
