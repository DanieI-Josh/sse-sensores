package br.pucgoias.sse_sensores.model;

public class LeituraTemperatura {

    private String sensor;
    private double valor;
    private long timestamp;

    public LeituraTemperatura() {
    }

    public LeituraTemperatura(String sensor, double valor, long timestamp) {
        this.sensor = sensor;
        this.valor = valor;
        this.timestamp = timestamp;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}