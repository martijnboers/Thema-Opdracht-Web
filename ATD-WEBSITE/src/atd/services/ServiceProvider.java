package atd.services;

public class ServiceProvider {
	private static VoorraadService voorraadService = new VoorraadService();
	private static AuthenticatieService authenticatieService = new AuthenticatieService();
	private static WerkplaatsService werkplaatsService = new WerkplaatsService();

	public static VoorraadService getVoorraadService() {
		return voorraadService;
	}

	public static AuthenticatieService getAuthenticatieService() {
		return authenticatieService;
	}

	public static WerkplaatsService getWerkplaatsService() {
		return werkplaatsService;
	}
}
