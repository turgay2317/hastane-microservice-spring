package com.turgayceylan.ReportMicroservice.config;

public class RestApis {
    public static final String DEV = "/dev";
    public static final String VERSION = "/v1";
    public static final String REPORT = DEV + VERSION + "/report";
    public static final String SAVE = "/";
    public static final String PUT = "/";
    public static final String GET = "/{id}";
    public static final String DELETE = "/{id}";
    public static final String ORDER = "/";

    /* Patient Microservice Endpoints */
    public static final String PATIENT = DEV + VERSION + "/patient";
    public static final String GET_PATIENT = PATIENT + "/{id}";

    /* Laborant Microservice Endpoints */
    public static final String LABORANT = DEV + VERSION + "/laborant";
    public static final String GET_LABORANT = LABORANT + "/{id}";
}
