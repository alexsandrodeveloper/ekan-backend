package br.com.ekan.exception;

public class BeneficiarioNotFoundException extends RuntimeException {
    public BeneficiarioNotFoundException(Long id) {
        super("Beneficiário não encontrado com ID: " + id);
    }
}