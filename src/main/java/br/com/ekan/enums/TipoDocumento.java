package br.com.ekan.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDocumento {
    RG("RG"),
    CPF("CPF"),
    CNPJ("CNPJ");

    private String value;

    TipoDocumento(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}