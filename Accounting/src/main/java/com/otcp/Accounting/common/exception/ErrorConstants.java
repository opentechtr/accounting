package com.otcp.Accounting.common.exception;


public class ErrorConstants {

    // Genel Hatalar
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Sunucuda bir hata oluştu";

    // Validasyon Hataları
    public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
    public static final String VALIDATION_ERROR_MESSAGE = "Geçersiz veri girişi";

    public static final String CONSTRAINT_VIOLATION = "CONSTRAINT_VIOLATION";
    public static final String CONSTRAINT_VIOLATION_MESSAGE = "Geçersiz parametre";

    // JSON Hataları
    public static final String JSON_PARSE_ERROR = "JSON_PARSE_ERROR";
    public static final String JSON_PARSE_ERROR_MESSAGE = "Gönderilen JSON formatı geçersiz";

    // Request Parametre Hataları
    public static final String MISSING_PARAMETER = "MISSING_PARAMETER";
    public static final String MISSING_PARAMETER_MESSAGE = "Gerekli parametre eksik";

    // Varlık Bulunamama Hatası
    public static final String ENTITY_NOT_FOUND = "ENTITY_NOT_FOUND";
    public static final String ENTITY_NOT_FOUND_MESSAGE = "İstenen veri bulunamadı";

    // Yetkisiz Erişim Hatası
    public static final String ACCESS_DENIED = "ACCESS_DENIED";
    public static final String ACCESS_DENIED_MESSAGE = "Bu işlemi gerçekleştirmek için yetkiniz yok";

    // Authentication Hataları
    public static final String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
    public static final String AUTHENTICATION_FAILED_MESSAGE = "Kimlik doğrulama başarısız";

    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
    public static final String USER_NOT_FOUND_MESSAGE = "Kullanıcı bulunamadı";

    // HTTP Metot Hataları
    public static final String METHOD_NOT_ALLOWED = "METHOD_NOT_ALLOWED";
    public static final String METHOD_NOT_ALLOWED_MESSAGE = "Bu endpoint için yanlış HTTP metodu kullanıldı";

    public static final String UNSUPPORTED_MEDIA_TYPE = "UNSUPPORTED_MEDIA_TYPE";
    public static final String UNSUPPORTED_MEDIA_TYPE_MESSAGE = "Desteklenmeyen medya türü";

    // HTTP İstek ve Dış Servis Hataları
    public static final String HTTP_CLIENT_ERROR = "HTTP_CLIENT_ERROR";
    public static final String HTTP_CLIENT_ERROR_MESSAGE = "İstek sırasında HTTP hatası oluştu";

    public static final String EXTERNAL_SERVICE_UNAVAILABLE = "EXTERNAL_SERVICE_UNAVAILABLE";
    public static final String EXTERNAL_SERVICE_UNAVAILABLE_MESSAGE = "Dış servise erişilemedi";

    public static final String REST_CLIENT_ERROR = "REST_CLIENT_ERROR";
    public static final String REST_CLIENT_ERROR_MESSAGE = "Dış API çağrısı başarısız";
}

