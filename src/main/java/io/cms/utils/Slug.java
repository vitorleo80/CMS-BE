package io.binaryforge.cms.utils;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 
 * @author Vitor Correa
 * @date 26 Feb 2019
 */
public class Slug {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	public String makeSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("-MMddyyyyhhmm");
		LocalDateTime localDateTime = LocalDateTime.now();
		String ldtString = FOMATTER.format(localDateTime);
		slug += ldtString;
		return slug.toLowerCase(Locale.ENGLISH);
	}
}
