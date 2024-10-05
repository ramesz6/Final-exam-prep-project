package org.example.backend.errors;

public class CannotVerifyUserError extends RuntimeException {
    public CannotVerifyUserError(String message) {
        super(message);
      }
}
