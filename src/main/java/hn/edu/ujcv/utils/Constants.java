package hn.edu.ujcv.utils;

public final class Constants {
    private static final String URL_API_BASE      = "/api";
    private static final String URL_API_VERSION   = "v1";
    private static final String URL_BASE          = URL_API_BASE + URL_API_VERSION;
    public static final String URL_BASE_AERONAVES = String.format("%s/aeronaves",URL_BASE);
    public static final String URL_BASE_BOLETOS = String.format("%s/boletos",URL_BASE);
    public static final String URL_BASE_EMPLEADOS = String.format("%s/empleados",URL_BASE);
    public static final String URL_BASE_PASAJEROS = String.format("%s/pasajeros",URL_BASE);
    public static final String URL_BASE_PERSONAS = String.format("%s/personas",URL_BASE);
    public static final String URL_BASE_VEHICULOSAEROPORTUARIOS = String.format("%s/vehiculosAeroportuarios",URL_BASE);
}
