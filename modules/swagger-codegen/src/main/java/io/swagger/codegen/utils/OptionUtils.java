package io.swagger.codegen.utils;

import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class OptionUtils {
	
	//AQCU Extension
	public static List<Pair<String, String>> parseTupleList(final List<String> tuples){
		final List<Pair<String, String>> results = new ArrayList<Pair<String, String>>();
		
		if(tuples != null){
			for (String tuple : tuples) {
				if(tuple.length() > 0){
					int ix = tuple.indexOf('=');
					if (ix > 0 && ix <= tuple.length() - 1) {
						final Pair<String, String> pair = Pair.of(tuple.substring(0, ix), tuple.substring(ix + 1));
						results.add(pair);
					} else if (ix < 0){
						final Pair<String, String> pair = Pair.of(tuple, "");
						results.add(pair);
					}
				}
			}
		}

        return results;
	}

    public static List<Pair<String, String>> parseCommaSeparatedTuples(final String input) {

        final List<String> tuples = splitCommaSeparatedList(input);

        return parseTupleList(tuples);
    }
   
    public static List<String> splitCommaSeparatedList(String input) {

        List<String> results = new ArrayList<String>();

        if(input != null && !input.isEmpty()) {
            for (String value : input.split(",")) {
                if(isNotEmpty(value))
                results.add(value);
            }
        }

        return results;
    }
}
