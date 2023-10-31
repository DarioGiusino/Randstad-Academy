package Main;

import java.util.Scanner;

public class Utilities {

	public static <T> T userInput(Class<T> type, String s) {
		Scanner sc = new Scanner(System.in);
		System.out.println(s);

		if (type == Integer.class) {
			int userInput = sc.nextInt();
			return type.cast(userInput);

		} else if (type == Double.class) {
			double userInput2 = sc.nextDouble();
			return type.cast(userInput2);

		} else if (type == String.class) {
			String userInput3 = sc.next();
			return type.cast(userInput3);

		} else if (type == Float.class) {
			Float userInput4 = sc.nextFloat();
			return type.cast(userInput4);
		}
		else {
			throw new IllegalArgumentException("Tipo non supportato: " + type.getSimpleName());
		}
	}

}
