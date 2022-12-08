package service;

public record Response<T>(T value, boolean isSuccessful, String message) {

    @Override
    public String toString() {
        return "service.Response{" +
                "value=" + value +
                ", isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                '}';
    }
}