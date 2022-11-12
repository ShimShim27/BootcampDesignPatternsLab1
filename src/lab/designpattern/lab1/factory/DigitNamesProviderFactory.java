package lab.designpattern.lab1.factory;

import lab.designpattern.lab1.base.DigitNamesProvider;
import lab.designpattern.lab1.entity.digitnamesprovider.BasicDigitNamesProvider;
import lab.designpattern.lab1.entity.digitnamesprovider.TenToNineteenDigitNamesProvider;
import lab.designpattern.lab1.entity.digitnamesprovider.TyEndingDigitNamesProvider;

public class DigitNamesProviderFactory {

	private static DigitNamesProviderFactory INSTANCE;
	private DigitNamesProvider basicDigitNamesProvider;
	private DigitNamesProvider tyEndingDigitNamesProvider;
	private DigitNamesProvider tenToNineteenDigitNamesProvider;

	public static enum ProviderType {
		TYPE_BASIC, TYPE_TY_ENDING, TYPE_TO_TEN_NINETEEN
	}

	
	private DigitNamesProviderFactory() {

	}

	public static DigitNamesProviderFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DigitNamesProviderFactory();
		}

		return INSTANCE;
	}

	public DigitNamesProvider createDigitNamesInstance(ProviderType type) throws IllegalArgumentException {
		DigitNamesProvider provider = null;
		switch (type) {
		case TYPE_BASIC:
			provider = this.getBasicDigitNamesProvider();
			break;

		case TYPE_TY_ENDING:
			provider = this.getTyEndingDigitNamesProvider();
			break;
		case TYPE_TO_TEN_NINETEEN:
			provider = this.getTenToNineteenDigitNamesProvider();
			break;
		default:
			throw new IllegalArgumentException("Invalid provider type");
		}

		return provider;
	}

	
	private DigitNamesProvider getBasicDigitNamesProvider() {
		if (basicDigitNamesProvider == null) {
			basicDigitNamesProvider = new BasicDigitNamesProvider();
		}
		return basicDigitNamesProvider;
	}

	private DigitNamesProvider getTyEndingDigitNamesProvider() {
		if (tyEndingDigitNamesProvider == null) {
			tyEndingDigitNamesProvider = new TyEndingDigitNamesProvider();
		}
		return tyEndingDigitNamesProvider;
	}

	private DigitNamesProvider getTenToNineteenDigitNamesProvider() {
		if (tenToNineteenDigitNamesProvider == null) {
			tenToNineteenDigitNamesProvider = new TenToNineteenDigitNamesProvider();
		}
		return tenToNineteenDigitNamesProvider;
	}

}
