package documin.documento;

import java.util.Comparator;

/**
 * Uma classe que compara o tamanho de duas strings.
 * 
 * @author Sérgio Gustavo de Andrade Grilo
 */
public class ComparadorTamanho implements Comparator<String> {

	/**
	 * Compara o tamanho de duas strings.
	 */
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() > o2.length()) {
			return 1;
		} else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
	}
}
